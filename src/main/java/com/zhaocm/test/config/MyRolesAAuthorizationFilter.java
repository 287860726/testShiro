package com.zhaocm.test.config;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.List;


public class MyRolesAAuthorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {
        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) o;

        if (rolesArray == null || rolesArray.length == 0) {
            return false;
        }

        List<String> roles = CollectionUtils.asList(rolesArray);
        boolean[] hasRoles = subject.hasRoles(roles);
        for (boolean hasRole : hasRoles) {
            if(hasRole){
                return true;
            }
        }
        return false;
    }
}
