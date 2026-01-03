TODO: postgreSQL (with or without profile (sdee best practice))

Activate profile in production:
Option 1: JVM argument
java -jar meal-planner.jar --spring.profiles.active=prod

Option 2: Environment variable
export SPRING_PROFILES_ACTIVE=prod

How to set Spring profiles in IntelliJ when running your app:
Method 1: Set profile in Run Configuration
The “Active profiles” field was added in later IntelliJ versions (2022+)
IntelliJ 2021.2 simply doesn’t have that UI feature
1. In IntelliJ, top-right corner → click Run / Debug Configurations (dropdown near ▶️).
2. Select your Spring Boot Application configuration.
3. Find “Active profiles” field.
4. Enter: dev or prod
5. Click Apply → OK
6. Run the app ▶️.

Method 2: VM Options (explicit & flexible)
1. Open Run / Debug Configurations
2. In VM options, add:
-Dspring.profiles.active=prod
3. Apply and run.

Method 3: Environment Variable
1. Open Run / Debug Configurations
2. Find Environment variables
3. Add:
SPRING_PROFILES_ACTIVE=prod
4. Apply and run.

Method 4: Program argumets
1. Open Run / Debug Configurations
2. In Program arguments, add:
   --spring.profiles.active=prod
3. Apply and run.

TIPS:
With prod profile (postgreSQL), ⚠️ The DB must exist (mealplanner), PostgreSQL must be running.

TO-DO:
1. nustatyti lenteles
2. kaip flyway cia isikompnuoja, ar reikia sukurti migracijas, kai keisis modelis, ar palikti kaip yra ir automatiskai?
Dev / learning:
   ✅ Let Spring/Hibernate update the schema automatically
   (spring.jpa.hibernate.ddl-auto=update)
Production:
❌ Do NOT rely on automatic schema changes
✅ Use Flyway (best choice) or Liquibase 
Tai pakeisti prod application-prod.properties:
   prod
   ddl-auto=validate or none
   Safety
ir paziureti kaip keisis modeliai, ir sutvarkyti modelius, naudoti flyway and prod
   🏁 Final recommendation for YOU
✔ Use Hibernate auto-update only in dev
✔ Introduce Flyway before production
✔ Keep SQL migrations under version control
✔ Never let Hibernate modify prod schema
Klausimas:
kaip migruoti duombaze, kai jau yra (buvo) spring.jpa.hibernate.ddl-auto=update ir pakeiciau i validate, ir yra issaugota schema duombazeje ir nori naudoti flyway. 
