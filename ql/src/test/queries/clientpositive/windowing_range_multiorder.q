drop table over10k_n17;

create table over10k_n17(
           t tinyint,
           si smallint,
           i int,
           b bigint,
           f float,
           d double,
           bo boolean,
           s string,
           ts timestamp,
           `dec` decimal(4,2),
           bin binary)
       row format delimited
       fields terminated by '|';

load data local inpath '../../data/files/over10k' into table over10k_n17;

select first_value(t) over ( partition by si order by i, b ) fv from over10k_n17 order by fv limit 100;

select last_value(i) over (partition by si, bo order by i, f desc range current row) lv from over10k_n17 order by lv limit 100;

select row_number() over (partition by si, bo order by i, f desc range between unbounded preceding and unbounded following) rn from over10k_n17 order by rn limit 100;

select s, si, i, avg(i) over (partition by s range between unbounded preceding and current row) a from over10k_n17 order by s, si, i, a limit 100;

select s, si, i, avg(i) over (partition by s order by si, i range between unbounded preceding and current row) a from over10k_n17 order by s, si, i, a limit 100;

select s, si, i, min(i) over (partition by s order by si, i range between unbounded preceding and current row) m from over10k_n17 order by s, si, i, m limit 100;

select s, si, i, avg(i) over (partition by s order by si, i desc range between unbounded preceding and current row) a from over10k_n17 order by s, si, i, a limit 100;

select si, bo, i, f, max(i) over (partition by si, bo order by i, f desc range between unbounded preceding and current row) m from over10k_n17 order by si, bo, i, f, m limit 100;

select bo, rank() over (partition by i order by bo nulls first, b nulls last range between unbounded preceding and unbounded following) r from over10k_n17 order by bo, r limit 100;

select CAST(s as CHAR(12)) s, rank() over (partition by i order by CAST(s as CHAR(12)) nulls last range between unbounded preceding and unbounded following) r from over10k_n17 order by s, r limit 100;

select CAST(s as VARCHAR(12)) s, rank() over (partition by i order by CAST(s as VARCHAR(12)) nulls last range between unbounded preceding and unbounded following) r from over10k_n17 order by s, r limit 100;
