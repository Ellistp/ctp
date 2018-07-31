package com.ctp.ghub.security;

import java.util.List;

import javax.annotation.Resource;

import com.ctp.ghub.model.PermissionDO;
import com.ctp.ghub.model.RoleDO;
import com.ctp.ghub.model.RolePermissionDO;
import com.ctp.ghub.model.UserDO;
import com.ctp.ghub.model.UserRoleDO;
import com.ctp.ghub.service.PermissionService;
import com.ctp.ghub.service.RolePermissionService;
import com.ctp.ghub.service.RoleService;
import com.ctp.ghub.service.UserRoleService;
import com.ctp.ghub.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private PermissionService permissionService;

    @Resource
    private RolePermissionService rolePermissionService;

    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String account = String.valueOf(principals.getPrimaryPrincipal());

        UserDO userDO = userService.selectByAccount(account);
        if(userDO == null){
            //没找到帐号
            throw new UnknownAccountException();
        }
        List<UserRoleDO> userRoleDOS = userRoleService.selectRolesByUserId(userDO.getId());
        if(CollectionUtils.isEmpty(userRoleDOS)){
            throw new AuthenticationException("当前用户缺少角色!");
        }
        for (UserRoleDO userRoleDO : userRoleDOS) {
            RoleDO roleDO = this.roleService.selectById(userRoleDO.getRoleId());
            // 添加角色
            authorizationInfo.addRole(roleDO.getRoleSign());

            List<RolePermissionDO> rolePermissionDOS = rolePermissionService.selectPermissionsByRoleId(roleDO.getId());
            if(CollectionUtils.isEmpty(rolePermissionDOS)){
                throw new AuthenticationException("当前角色缺少权限!");
            }
            for (RolePermissionDO rolePermissionDO : rolePermissionDOS) {
                PermissionDO permissionDO = this.permissionService.selectById(rolePermissionDO.getPermissionId());
                // 添加权限
                authorizationInfo.addStringPermission(permissionDO.getPermissionSign());
            }
        }
        return authorizationInfo;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = String.valueOf(token.getPrincipal());
        // 通过数据库进行验证
        UserDO userDO = this.userService.selectByAccount(account);
        if(userDO == null){
            //没找到帐号
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(account, userDO.getPassword(), new ShiroByteSource(userDO.getSalt()),getName());
        return authenticationInfo;
    }
}
