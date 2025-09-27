
# Peer-to-Peer Skill Exchange Platform

A Java-based GUI platform (using Swing) where students can register, log in, and search for skills to exchange with peers. The application aims to foster a collaborative learning environment by enabling users to offer and request skills in a secure, user-friendly interface.

## Team Roles

- **Member 1: User Management**  
	Responsible for user registration, login, and profile management.  
	_Files: `User.java`, `Login.java`, `Register.java`_
- **Member 2: Database**  
	Handles all database operations, including storing and retrieving user and skill data.  
	_File: `Database.java`_
- **Member 3: GUI**  
	Designs and implements the graphical user interface using Java Swing.  
	_File: `GuiApp.java`_
- **Integrator**  
	Integrates all modules and ensures smooth application flow.  
	_File: `Main.java`_

## Project Structure

```
peer-to-peer-skill-exchange/
├── src/
│   ├── main/
│   │   └── Main.java
│   ├── user/
│   │   ├── User.java
│   │   ├── Login.java
│   │   └── Register.java
│   ├── database/
│   │   └── Database.java
│   └── gui/
│       └── GuiApp.java
├── .gitignore
├── README.md
```

## How to Run

1. **Clone the repository:**
	 ```bash
	 git clone https://github.com/Geddy-Wendot/peer-to-peer-skill-exchange.git
	 ```
2. **Open the project** in your preferred Java IDE (IntelliJ IDEA, Eclipse, etc.).
3. **Navigate to** `src/main/Main.java`.
4. **Run** `Main.java` to start the application.

## Future Improvements
- Implement a user rating and review system
- Integrate with a persistent database (e.g., MySQL, PostgreSQL)
- Upgrade the GUI for a more modern look and feel

## Git Workflow Guide

- **Branching:**
	- Each member works on their own branch:
		- `user-management` (Member 1)
		- `database` (Member 2)
		- `gui` (Member 3)
- **Workflow:**
	1. Clone the repository
	2. Create and switch to your branch
		 ```bash
		 git checkout -b your-branch-name
		 ```
	3. Make changes, commit, and push regularly
		 ```bash
		 git add .
		 git commit -m "Your message"
		 git push origin your-branch-name
		 ```
	4. Pull the latest changes from `main` before making a pull request
		 ```bash
		 git pull origin main
		 ```
	5. Open a pull request for code review and integration

---

**Each member codes in their branch, integration will be smooth!**
