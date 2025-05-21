<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" rel="stylesheet">
</head>
<body class="bg-gray-50 min-h-screen">
<!-- 顶部导航栏 -->
<nav class="bg-white shadow-md fixed top-0 left-0 right-0 z-50">
    <div class="container mx-auto px-4 py-3 flex justify-between items-center">
        <div class="flex items-center space-x-2">
            <i class="fa fa-home text-primary text-xl"></i>
            <span class="font-bold text-lg text-gray-800">我的网站</span>
        </div>
        <div class="flex items-center space-x-6">
            <a href="#" class="text-gray-600 hover:text-primary transition-colors">首页</a>
            <a href="#" class="text-gray-600 hover:text-primary transition-colors">服务</a>
            <a href="#" class="text-gray-600 hover:text-primary transition-colors">关于</a>
            <div class="flex items-center space-x-2">
                <i class="fa fa-user-circle text-primary"></i>
                <span class="font-medium"><%= session.getAttribute("username") %></span>
                <a href="LogoutServlet" class="text-gray-500 hover:text-red-500 transition-colors">
                    <i class="fa fa-sign-out-alt"></i>
                </a>
            </div>
        </div>
    </div>
</nav>

<!-- 主内容区 -->
<div class="container mx-auto pt-24 pb-12 px-4">
    <div class="bg-white rounded-xl shadow-lg p-6 mb-6">
        <h2 class="text-2xl font-bold text-gray-800 mb-4">欢迎回来，<%= session.getAttribute("username") %>！</h2>
        <p class="text-gray-600 mb-6">这是您的个人主页，您可以在这里管理您的账户信息和设置。</p>

        <div class="grid grid-cols-1 md:grid-cols-3 gap-6">
            <div class="bg-blue-50 border border-blue-100 rounded-lg p-5 hover:shadow-md transition-shadow">
                <div class="flex items-center mb-3">
                    <div class="bg-blue-100 p-3 rounded-full mr-3">
                        <i class="fa fa-user text-blue-500 text-xl"></i>
                    </div>
                    <h3 class="font-semibold text-gray-800">个人信息</h3>
                </div>
                <p class="text-gray-600 text-sm">查看和编辑您的个人资料</p>
            </div>

            <div class="bg-green-50 border border-green-100 rounded-lg p-5 hover:shadow-md transition-shadow">
                <div class="flex items-center mb-3">
                    <div class="bg-green-100 p-3 rounded-full mr-3">
                        <i class="fa fa-cog text-green-500 text-xl"></i>
                    </div>
                    <h3 class="font-semibold text-gray-800">账户设置</h3>
                </div>
                <p class="text-gray-600 text-sm">管理您的账户安全和偏好</p>
            </div>

            <div class="bg-purple-50 border border-purple-100 rounded-lg p-5 hover:shadow-md transition-shadow">
                <div class="flex items-center mb-3">
                    <div class="bg-purple-100 p-3 rounded-full mr-3">
                        <i class="fa fa-bell text-purple-500 text-xl"></i>
                    </div>
                    <h3 class="font-semibold text-gray-800">通知中心</h3>
                </div>
                <p class="text-gray-600 text-sm">查看您的最新通知和消息</p>
            </div>
        </div>
    </div>

    <div class="bg-white rounded-xl shadow-lg p-6">
        <h3 class="text-xl font-bold text-gray-800 mb-4">最近活动</h3>
        <div class="overflow-x-auto">
            <table class="min-w-full">
                <thead>
                <tr class="bg-gray-50">
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">日期</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">活动</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">IP地址</th>
                    <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">位置</th>
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <tr>
                    <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"><%= new Date() %></td>
                    <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">登录成功</td>
                    <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">127.0.0.1</td>
                    <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">本地</td>
                </tr>
                <!-- 更多活动记录 -->
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- 页脚 -->
<footer class="bg-gray-800 text-white py-8">
    <div class="container mx-auto px-4">
        <div class="flex flex-col md:flex-row justify-between items-center">
            <div class="mb-4 md:mb-0">
                <div class="flex items-center space-x-2">
                    <i class="fa fa-home text-primary text-xl"></i>
                    <span class="font-bold text-lg">我的网站</span>
                </div>
                <p class="text-gray-400 mt-2">© 2025 我的网站. 保留所有权利.</p>
            </div>
            <div class="flex space-x-6">
                <a href="#" class="text-gray-400 hover:text-white transition-colors">
                    <i class="fa fa-facebook"></i>
                </a>
                <a href="#" class="text-gray-400 hover:text-white transition-colors">
                    <i class="fa fa-twitter"></i>
                </a>
                <a href="#" class="text-gray-400 hover:text-white transition-colors">
                    <i class="fa fa-instagram"></i>
                </a>
                <a href="#" class="text-gray-400 hover:text-white transition-colors">
                    <i class="fa fa-linkedin"></i>
                </a>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
