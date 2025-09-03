# Tutor DB

## Description

Tutor DB is proprietary software designed for maintaining a database of tutors, students, and their groups. It is intended for tracking lessons, managing information about students and their parents, and automatically calculating earnings.

## Licensing

The distribution and use of this software are governed by the terms outlined in the [LICENSE](LICENSE) file.

## Functionality

### 1. Student and Group Database

The program allows storing information about students and groups.

**Student** - an entity with the following parameters:
- Name, age
- Social media contacts
- Parent (if necessary)
- List of subjects
- Price per hour of lessons

**Subject** - a field of study (e.g., Mathematics, Chemistry).

**Social Networks** - the following platforms are supported:
- Telegram
- WhatsApp
- VKontakte

**Parent** - added if the student is a minor or if the customer is the parent. Parameters:
- Name
- Age
- Social media contacts

**Student Group** - a union of students studying together. Parameters:
- Group name
- Subject
- List of students in the group

### 2. Lesson Database

**Lesson** - a record of a conducted session. It can be:
- Individual (with one student)
- Group (with a group of students)

Lesson parameters:
- Date of the lesson
- Duration
- Student or group (depending on the type)
- Cost for the student(s)

### 3. Earnings Calculation

The program provides the ability to calculate earnings taking into account:
- Students and groups
- Subjects
- Lesson dates
- Specific students

Calculation results are displayed in the form of graphs.

---

## Installation and Launch

Installation and launch instructions will be provided by the copyright holder.

## Tech Stack

* **Language:** Kotlin
* **UI Framework:** Compose for Desktop
* **IDE:** JetBrains IntelliJ IDEA
* **ORM / Database Layer:** JetBrains Exposed
* **Database:** SQLite

## Contacts

For licensing and usage inquiries, please contact the copyright holder.

