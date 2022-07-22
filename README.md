# SpringBoot-ShortURL
Url shortener

Url Shortener Save =>

Request:
```
{
    "fullUrl":"localhost:8080/customer/all"
}

```

Response:

```
{
    "id": 10,
    "fullUrl": "localhost:8080/customer/all",
    "shortUrl": "a7acb5"
}

```

Usage:

Request:

```
localhost:8080/a7acb5

```

Repsonse:

```
[
    {
        "id": 1,
        "username": "Alex",
        "email": "Alex@gmail.com",
        "country": "United Kingdom",
        "birthday": "11/08/2000"
    },
    {
        "id": 2,
        "username": "Jennifer",
        "email": "jennifer@yahoo.com",
        "country": "Italy",
        "birthday": "23/11/1996"
    },
    {
        "id": 3,
        "username": "Zion",
        "email": "williamson@gmail.com",
        "country": "USA",
        "birthday": "06/07/2000"
    }
]

```




