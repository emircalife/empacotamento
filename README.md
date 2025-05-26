End-point http://localhost:8085/empacotamento-api/swagger-ui/index.html

# Exercício 2 - Horário de Aulas

# Questão 01:
------------
``` sql
select 	pr.id,
	TIMEDIFF(cs.start_time, cs.end_time) as horas_comprometidas
from professor pr
inner join professor_class pc on pr.id = pc.professor_id
inner join class cl on cl.id = pc.class_id
inner join class_shedule cs on cl.id = cs.class_id;
```
# Questão 02:
------------
``` sql
select 	cl.id,
	cs.start_time,
	cs.end_time,
	case cs.start_time when cs.start_time is null then 'LIVRE'
	else 'OCUPADA'
	end as horario
from class_shedule cs
inner join class cl on cs.class_id = cl.id;
```
