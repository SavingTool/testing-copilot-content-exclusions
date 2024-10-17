// personClass.ts

interface PersonDetails {
    firstName: string;
    lastName: string;
    age: number;
}

export class Person implements PersonDetails {
    firstName: string;
    lastName: string;
    age: number;

    constructor(firstName: string, lastName: string, age: number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    getFullName(): string {
        return `${this.firstName} ${this.lastName}`;
    }

    isAdult(): boolean {
        return this.age >= 18;
    }
}

// Example usage
const person = new Person('John', 'Doe', 25);
console.log(person.getFullName()); // John Doe
console.log(person.isAdult()); // true
