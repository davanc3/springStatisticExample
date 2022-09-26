<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
    <h1>Сайт, который собирает статистику просмотра страниц</h1>
    <h4>Количество уникальных посетителей данной страницы: ${usersCount}</h4>
    <p>Для того, чтобы посмотреть собранную статистику вы можете перейти на следующие страницы:</p>
    <button onclick="window.location.href = '/detail/';">Статистика текущего пользователя</button>
    <br>
    <br>
    <button onclick="window.location.href = '/all-users/';">Статистика всех пользователей</button>
    <br>
</body>
</html>
