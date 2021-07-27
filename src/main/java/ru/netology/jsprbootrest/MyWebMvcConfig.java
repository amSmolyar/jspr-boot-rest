package ru.netology.jsprbootrest;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserParamResolver());
    }

    private class UserParamResolver implements HandlerMethodArgumentResolver {
        @Override
        public boolean supportsParameter(MethodParameter methodParameter) {
            return methodParameter.getParameterType().equals(User.class);
        }

        @Override
        public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
            String user = nativeWebRequest.getParameter("user");
            String password = nativeWebRequest.getParameter("password");

            return new User(user, password);
        }
    }
}
