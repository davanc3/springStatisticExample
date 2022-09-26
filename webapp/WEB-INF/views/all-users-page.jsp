<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Общая страница всех пользователей</title>
</head>
<body>
    <h1>Статистика всех пользователей:</h1>
    <h4>Количество уникальных посетителей данного приложения: ${usersCount}</h4>
    <h4>Количество уникальных посетителей данной страницы: ${usersOnPageCount}</h4>
    <p>Количество просмотров страниц всеми пользователями в рамках работы данного приложения: ${allUsersViewsCount}</p>
    <h3>Детальное количество просмотров страниц всеми пользователями: </h3>
    <p>Главная страница: ${allUsersViewsCountOnMainPage}</p>
    <p>Статистика текущего пользователя: ${allUsersViewsCountOnDetailPage}</p>
    <p>Статистика всех пользователей: ${allUsersViewsCountOnAllUsersPage}</p>
    <button onclick="window.location.href = '/';">Вернутся на главную</button>
</body>
</html>
