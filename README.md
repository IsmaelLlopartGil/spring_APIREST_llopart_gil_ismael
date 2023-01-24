s05t02n01 Llopart Gil Ismael

Ús:
1- Petició GET a http://localhost/load_default_user
crea l'usuari per defecte i el retorna.
2- Petició POST a http://localhost/login amb les dades següents:
{
     "email": "default_user@jocdelset.edu",
     "password": "pass"
}
3- Guardar el bearer token que retorna i enviar-lo a cada petició.


Fonts:

JWT ->  https://www.youtube.com/watch?v=_p-Odh3MZJc
Mongodb -> https://docs.spring.io/spring-data/mongodb/docs/2.1.4.RELEASE/reference/html/#mongo-template.save-update-remove


