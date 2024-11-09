export class User {
     id: number | null;
     name: string;
     email: string;
     phone: string;
     password: string;
     role: string;

    constructor(id: number | null, name: string, email: string, phone: string, password: string, role: string) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }
}
