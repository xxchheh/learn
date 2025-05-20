<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" rel="stylesheet">
    <script>
        tailwind.config = {
            theme: {
                extend: {
                    colors: {
                        primary: '#3B82F6',
                        secondary: '#1E40AF',
                        accent: '#60A5FA',
                        neutral: '#F3F4F6',
                    },
                    fontFamily: {
                        sans: ['Inter', 'system-ui', 'sans-serif'],
                    },
                }
            }
        }
    </script>
    <style type="text/tailwindcss">
        @layer utilities {
            .content-auto {
                content-visibility: auto;
            }
            .form-input-focus {
                @apply focus:ring-2 focus:ring-primary/50 focus:border-primary transition duration-200;
            }
            .btn-hover {
                @apply hover:shadow-lg hover:-translate-y-0.5 transition-all duration-200;
            }
        }
    </style>
</head>
<body class="bg-gradient-to-br from-blue-50 to-indigo-100 min-h-screen flex items-center justify-center p-4">
<div class="w-full max-w-md bg-white rounded-xl shadow-xl overflow-hidden transform transition-all duration-500 hover:shadow-2xl">
    <div class="bg-gradient-to-r from-primary to-secondary text-white p-6">
        <h3 class="text-2xl font-bold text-center mb-2">用户登录</h3>
        <p class="text-center text-blue-100">欢迎回来，请登录您的账户</p>
    </div>

    <!-- 显示错误消息 -->
    <% if (request.getAttribute("error") != null) { %>
    <div class="bg-red-50 border-l-4 border-red-400 p-4 mb-4">
        <p class="text-red-700"><i class="fa fa-exclamation-circle mr-2"></i><%= request.getAttribute("error") %></p>
    </div>
    <% } %>

    <form action="LoginServlet" method="post" class="p-6 space-y-4">
        <div class="relative">
            <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
                <i class="fa fa-user text-gray-400"></i>
            </div>
            <input type="text" name="username" id="username"
                   class="w-full pl-10 pr-4 py-3 rounded-lg border border-gray-300 form-input-focus"
                   placeholder="请输入用户名" required
                   value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : "" %>">
        </div>
        <div class="relative">
            <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
                <i class="fa fa-lock text-gray-400"></i>
            </div>
            <input type="password" name="password" id="password"
                   class="w-full pl-10 pr-4 py-3 rounded-lg border border-gray-300 form-input-focus"
                   placeholder="请输入密码" required>
        </div>
        <div class="flex flex-wrap items-center gap-4">
            <div class="flex items-center space-x-2">
                <input type="radio" id="month" name="autologin" value="一个月" class="accent-primary"
                    <%= "一个月".equals(request.getAttribute("autologin")) ? "checked" : "" %>>
                <label for="month" class="text-sm text-gray-700">一个月</label>
            </div>
            <div class="flex items-center space-x-2">
                <input type="radio" id="quarter" name="autologin" value="三个月" class="accent-primary"
                    <%= "三个月".equals(request.getAttribute("autologin")) ? "checked" : "" %>>
                <label for="quarter" class="text-sm text-gray-700">三个月</label>
            </div>
            <div class="flex items-center space-x-2">
                <input type="radio" id="halfyear" name="autologin" value="半年" class="accent-primary"
                    <%= "半年".equals(request.getAttribute("autologin")) ? "checked" : "" %>>
                <label for="halfyear" class="text-sm text-gray-700">半年</label>
            </div>
            <div class="flex items-center space-x-2">
                <input type="radio" id="year" name="autologin" value="一年" class="accent-primary"
                    <%= request.getAttribute("autologin") == null || "一年".equals(request.getAttribute("autologin")) ? "checked" : "" %>>
                <label for="year" class="text-sm text-gray-700">一年</label>
            </div>
        </div>
        <div class="pt-2">
            <button type="submit"
                    class="w-full bg-primary hover:bg-secondary text-white font-medium py-3 px-4 rounded-lg btn-hover">
                <i class="fa fa-sign-in mr-2"></i>登录
            </button>
        </div>
    </form>
    <div class="bg-neutral p-4 text-center text-sm text-gray-600">
        <p>还没有账户? <a href="register.jsp" class="text-primary hover:underline">立即注册</a></p>
    </div>
</div>
</body>
</html>
