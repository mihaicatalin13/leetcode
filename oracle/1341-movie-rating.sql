select  usr.name results
from    (
    select  u.name
    ,       count(*) movies_rated
    from    users u
    ,       movierating mr
    where   u.user_id = mr.user_id
    group by u.user_id, u.name
    order by movies_rated desc, u.name asc
) usr
where rownum = 1
union all
select  mov.title results
from    (
    select  m.title
    ,       avg(mr.rating) avg_rating
    from    movierating mr
    ,       movies m
    where   mr.movie_id = m.movie_id
    and     extract(month from created_at) = 2
    and     extract(year from created_at) = 2020
    group by m.movie_id, m.title
    order by avg_rating desc, m.title asc
) mov
where rownum = 1