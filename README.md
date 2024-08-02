## Sistema de gestion de cliente de optica

### agregar folder data en raiz para persistencia
- muestre de datos
- [
  {
  "name": "Ana Rodríguez",
  "age": 29,
  "email": "ana.rodriguez@email.com",
  "phone": "555-1111",
  "service": "Examen de vista",
  "product": "Lentes de contacto",
  "visitHistory": ["Primera visita: Examen completo"],
  "lastVisitDate": "2024-07-15"
  },
  {
  "name": "Carlos Gómez",
  "age": 45,
  "email": "carlos.gomez@email.com",
  "phone": "555-2222",
  "service": "Ajuste de lentes",
  "product": "Lentes bifocales",
  "visitHistory": ["Ajuste de lentes bifocales"],
  "lastVisitDate": "2024-07-16"
  },
  {
  "name": "Elena Martínez",
  "age": 32,
  "email": "elena.martinez@email.com",
  "phone": "555-3333",
  "service": "Control anual",
  "product": "Gafas de sol",
  "visitHistory": ["Control anual: Sin cambios significativos"],
  "lastVisitDate": "2024-07-17"
  },
  {
  "name": "David Sánchez",
  "age": 58,
  "email": "david.sanchez@email.com",
  "phone": "555-4444",
  "service": "Tratamiento de ojo seco",
  "product": "Gotas lubricantes",
  "visitHistory": ["Diagnóstico de ojo seco", "Inicio de tratamiento"],
  "lastVisitDate": "2024-07-18"
  },
  {
  "name": "Isabel López",
  "age": 23,
  "email": "isabel.lopez@email.com",
  "phone": "555-5555",
  "service": "Adaptación lentes de contacto",
  "product": "Lentes de contacto tóricas",
  "visitHistory": ["Primera adaptación de lentes tóricas"],
  "lastVisitDate": "2024-07-19"
  },
  {
  "name": "Fernando Torres",
  "age": 41,
  "email": "fernando.torres@email.com",
  "phone": "555-6666",
  "service": "Revisión post-operatoria",
  "product": null,
  "visitHistory": ["Cirugía de cataratas hace 1 mes", "Evolución favorable"],
  "lastVisitDate": "2024-07-20"
  },
  {
  "name": "Lucía Navarro",
  "age": 37,
  "email": "lucia.navarro@email.com",
  "phone": "555-7777",
  "service": "Examen de presión intraocular",
  "product": "Colirio para glaucoma",
  "visitHistory": ["Detección de presión elevada", "Inicio tratamiento glaucoma"],
  "lastVisitDate": "2024-07-21"
  },
  {
  "name": "Roberto Herrera",
  "age": 52,
  "email": "roberto.herrera@email.com",
  "phone": "555-8888",
  "service": "Adaptación de lentes progresivas",
  "product": "Lentes progresivas",
  "visitHistory": ["Primera adaptación a progresivos"],
  "lastVisitDate": "2024-07-22"
  },
  {
  "name": "Carmen Jiménez",
  "age": 19,
  "email": "carmen.jimenez@email.com",
  "phone": "555-9999",
  "service": "Revisión de miopía",
  "product": "Lentes para miopía",
  "visitHistory": ["Control de miopía", "Aumento de graduación"],
  "lastVisitDate": "2024-07-23"
  },
  {
  "name": "Miguel Ángel Ruiz",
  "age": 63,
  "email": "miguel.ruiz@email.com",
  "phone": "555-0000",
  "service": "Examen de fondo de ojo",
  "product": "Suplementos vitamínicos oculares",
  "visitHistory": ["Examen de retina", "Recomendación de suplementos"],
  "lastVisitDate": "2024-07-24"
  }
  ]

### Postman para probar los endpoints:

POST http://localhost:8080/api/patients (Crear paciente)
GET http://localhost:8080/api/patients (Obtener todos los pacientes)
GET http://localhost:8080/api/patients/{id} (Obtener paciente por ID)
PUT http://localhost:8080/api/patients/{id} (Actualizar paciente)
DELETE http://localhost:8080/api/patients/{id} (Eliminar paciente)


### Busquedas filtradas
Búsqueda general (por nombre, teléfono o email):
GET http://localhost:8080/api/patients/search?searchTerm=juan
Búsqueda por nombre:
GET http://localhost:8080/api/patients/search/name?name=juan
Búsqueda por teléfono:
GET http://localhost:8080/api/patients/search/phone?phone=555
Búsqueda por email:
GET http://localhost:8080/api/patients/search/email?email=juan@email.com