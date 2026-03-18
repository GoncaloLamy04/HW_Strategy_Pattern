# Strategy Pattern med Global Fejlhåndtering

## Beskrivelse
En simpel Spring Boot applikation hvor brugere kan registrere sig.
Input valideres med to forskellige strategier, og fejl håndteres centralt.

## Funktionalitet
- Brugerregistrering med username, email og password
- To valideringsstrategier der vælges via dropdown:
  - Simple: grundlæggende validering
  - Strict: strengere krav til input
- Fejl vises samlet på en fejlside
- Global fejlhåndtering med @ControllerAdvice

## Arkitektur
- Controller: håndterer HTTP requests
- Service: vælger valideringsstrategi
- Validation: SimpleValidationStrategy og StrictValidationStrategy
- Model: RegisterUserModel

## Kør projektet
1. Åbn projektet i IntelliJ
2. Kør SpringBootApplication
3. Gå til http://localhost:8080/register

## Tests
Kør unit tests i IntelliJ med grøn play-knap på testklasserne.
