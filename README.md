# Records

### Records are immutable containers for data.
### Compiler translate records to classes with private final fields.
### Constructor that initializes all fields.
### Accessor methods for each field.
### `equals()`, `hashCode()`, and `toString()` methods.
### Records are mutable.

## Use cases
### Immutable data model class.

## Example

```java
public record Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime) {
} 
```

## Constructing a Record
### Compiler generates a canonical constructor that initializes all fields.
### You can define your own constructor, but it must initialize all fields.

## Canonical Constructor
### Parameter list matches the record components.
### Initializes all fields in the component.
### can not have throws clause.
### Can not call `this()` or `super()`.
### Access level must not be more restrictive than the record itself(record access level is public canonical Constructor must be public).
```java
public record Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime) {

    public Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime) {
        this.origin = Objects.requireNonNull(origin, "Origin cannot be null");
        this.via = Objects.requireNonNull(via, "Via cannot be null");
        this.destination = Objects.requireNonNull(destination, "Destination cannot be null");
        this.departureTime = Objects.requireNonNull(departureTime, "Departure time cannot be null");
        this.arrivalTime = Objects.requireNonNull(arrivalTime, "Arrival time cannot be null");
    }
}
```
## Compact Constructor
### All the fields must be initialized
```java
public record Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime) {

    public Journey {
        Objects.requireNonNull(origin, "Origin cannot be null");
        Objects.requireNonNull(via, "Via cannot be null");
        Objects.requireNonNull(destination, "Destination cannot be null");
        Objects.requireNonNull(departureTime, "Departure time cannot be null");
        Objects.requireNonNull(arrivalTime, "Arrival time cannot be null");
    }
}
```

## Additional Constructors
### You can define additional constructors with different parameter lists.
### Must call the canonical constructor directly or indirectly.
```java
public record Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime) {

    public Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime) {
        this.origin = Objects.requireNonNull(origin, "Origin cannot be null");
        this.via = Objects.requireNonNull(via, "Via cannot be null");
        this.destination = Objects.requireNonNull(destination, "Destination cannot be null");
        this.departureTime = Objects.requireNonNull(departureTime, "Departure time cannot be null");
        this.arrivalTime = Objects.requireNonNull(arrivalTime, "Arrival time cannot be null");
    }

    public Journey(String origin, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime) {
        this(origin, List.of(), destination, departureTime, arrivalTime);
    }
}
```

### Records can not have instance fields other than the record components.
### Records can have static fields and methods.
### Records can implement interfaces.
### Records can not extend other classes.


# Pattern Matching for Records
### Pattern matching for records allows you to deconstruct a record into its components.
### You can use pattern matching in `instanceof` expressions and `switch` statements.
```java
public static void startNationalTour(Tour tour) {
    if (tour instanceof NationalTour nationalTour) {
        System.out.println("Starting national tour from " + nationalTour.origin() + " to " + nationalTour.destination()+" via " + nationalTour.location());
    } else if (tour instanceof InterNationalTour interNationalTour) {
        System.out.println("Starting international tour from " + interNationalTour.origin() + " to " + interNationalTour.destination()+" with passport number " + interNationalTour.passportNumber() + " and visa number " + interNationalTour.visaNumber());
    }
}
```
## pattern matching in switch statements
```java
public static void startNationalTourSwitch(Tour tour) {
    switch (tour){
        case NationalTour nationalTour -> System.out.println("Starting national tour from " + nationalTour.origin() + " to " + nationalTour.destination()+" via " + nationalTour.location());
        case InterNationalTour interNationalTour -> System.out.println("Starting international tour from " + interNationalTour.origin() + " to " + interNationalTour.destination()+" with passport number " + interNationalTour.passportNumber() + " and visa number " + interNationalTour.visaNumber());
        default -> throw new IllegalStateException("Unexpected value: " + tour);
    }
}
```
### You can nest patterns to deconstruct nested records.

## Guarded Patterns
```java
public static void startNationalTourSwitchGuarded(Tour tour) {
        switch (tour){
            case NationalTour nationalTour when nationalTour.location().equals("India") -> System.out.println("Starting national tour from " + nationalTour.origin() + " to " + nationalTour.destination()+" via " + nationalTour.location());
            case InterNationalTour interNationalTour when interNationalTour.passportNumber().startsWith("A") -> System.out.println("Starting international tour from " + interNationalTour.origin() + " to " + interNationalTour.destination()+" with passport number " + interNationalTour.passportNumber() + " and visa number " + interNationalTour.visaNumber()); 
            case NationalTour nationalTour -> System.out.println("Starting national tour from " + nationalTour.origin() + " to " + nationalTour.destination()+" via " + nationalTour.location());
            case InterNationalTour interNationalTour -> System.out.println("Starting international tour from " + interNationalTour.origin() + " to " + interNationalTour.destination()+" with passport number " + interNationalTour.passportNumber() + " and visa number " + interNationalTour.visaNumber());
            default -> throw new IllegalStateException("Unexpected value: " + tour);
        }
    }
```
## Primitive pattern matching
```java
public static  void numberToString(int number){
        String numberString = switch (number) {
            case int s when s < 10 -> "One";
            case int s when s < 20  -> "Two";
            case int s when s < 30 -> "Three";
            case int s when s < 40 -> "Four";
            case int s when s < 50 -> "Five";
            default -> "Unknown";
        };
    }
```
## Record Patterns in Enhanced for Loop
```java
public static void recordPatternMatching(Tour tour) {
        switch (tour){
            case NationalTour(String origin, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime, String location) -> System.out.println("Starting national tour from " + origin + " to " + destination+" via " + location);
            case InterNationalTour(String origin, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime, String passportNumber, String visaNumber) -> System.out.println("Starting international tour from " + origin + " to " + destination+" with passport number " + passportNumber + " and visa number " + visaNumber);
            default -> throw new IllegalStateException("Unexpected value: " + tour);
        }
    }
``` 
## Nested Record Patterns
```java
public static void nestedPatternMatching(Ticket ticket) {
        switch (ticket){
            case Ticket(var pnr,
                        Route(String start, String end),
                        Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime),
                        Passenger(String name, String email, String phoneNumber))-> System.out.println("Ticket PNR: " + pnr + ", Route: " + start + " to " + end + ", Journey: " + origin + " to " + destination + ", Passenger: " + name);
            case Ticket(var pnr,
                        var route,
                        Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime),
                        Passenger(String name, String email, String phoneNumber))-> System.out.println("Ticket PNR: " + pnr + ", Journey: " + origin + " to " + destination + ", Passenger: " + name);
            default -> throw new IllegalStateException("Unexpected value: " + ticket);
        }
    }
```

