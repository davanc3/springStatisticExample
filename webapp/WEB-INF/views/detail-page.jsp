<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Детальная страница пользователя</title>
</head>
<body>
    <h1>Статистика текущего пользователя:</h1>
    <h4>Количество уникальных посетителей данной страницы: ${usersCount}</h4>
    <p>Количество просмотров страниц текущим пользователем: ${userViewsCount}</p>
    <h3>Детальное количество просмотров страниц текущим пользователем:</h3>
    <p>Главная страница: ${mainPageViews}</p>
    <p>Статистика текущего пользователя: ${detailPageViews}</p>
    <p>Статистика всех пользователей: ${allUsersPageViews}</p>
    <button onclick="window.location.href = '/';">Вернутся на главную</button>
</body>
</html>
