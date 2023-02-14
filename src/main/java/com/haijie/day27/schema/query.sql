use bgg;
 
select name,year,ranking,users_rated,image from game where gid=20;

select g.gid,g.name, avg(c.rating)
from game g 
left join comment c
on g.gid = c.gid
group by g.gid;