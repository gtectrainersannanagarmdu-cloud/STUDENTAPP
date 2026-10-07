package com.gtec.studentapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    // Temporary storage for students
    private List<String> students = new ArrayList<>();


    // =========================================================
    // HOME PAGE
    // =========================================================

    @GetMapping(value = "/hello", produces = "text/html")
    public String home() {

        return """
                <!DOCTYPE html>
                <html>

                <head>

                    <title>Student Management System</title>

                    <style>

                        * {
                            margin: 0;
                            padding: 0;
                            box-sizing: border-box;
                            font-family: Arial, sans-serif;
                        }

                        body {
                            background: linear-gradient(135deg, #667eea, #764ba2);
                            min-height: 100vh;
                        }

                        nav {
                            background: white;
                            padding: 20px 50px;
                            display: flex;
                            justify-content: space-between;
                            align-items: center;
                            box-shadow: 0 3px 15px rgba(0,0,0,0.2);
                        }

                        .logo {
                            font-size: 25px;
                            font-weight: bold;
                            color: #667eea;
                        }

                        nav a {
                            text-decoration: none;
                            color: #444;
                            margin-left: 25px;
                            font-weight: bold;
                        }

                        nav a:hover {
                            color: #667eea;
                        }

                        .hero {
                            width: 85%;
                            max-width: 1000px;
                            margin: 80px auto;
                            background: white;
                            padding: 70px;
                            border-radius: 30px;
                            text-align: center;
                            box-shadow: 0 20px 50px rgba(0,0,0,0.3);
                        }

                        .hero-icon {
                            font-size: 80px;
                        }

                        h1 {
                            color: #333;
                            font-size: 42px;
                            margin: 20px 0;
                        }

                        .hero p {
                            color: #666;
                            font-size: 20px;
                            margin-bottom: 30px;
                        }

                        .button {
                            display: inline-block;
                            padding: 15px 30px;
                            background: #667eea;
                            color: white;
                            text-decoration: none;
                            border-radius: 30px;
                            font-weight: bold;
                        }

                        .button:hover {
                            background: #764ba2;
                        }

                        .cards {
                            display: flex;
                            justify-content: center;
                            gap: 25px;
                            margin-top: 50px;
                            flex-wrap: wrap;
                        }

                        .card {
                            width: 220px;
                            padding: 30px 20px;
                            background: #f5f7ff;
                            border-radius: 20px;
                            transition: 0.3s;
                        }

                        .card:hover {
                            transform: translateY(-10px);
                            box-shadow: 0 10px 25px rgba(0,0,0,0.15);
                        }

                        .card-icon {
                            font-size: 50px;
                            margin-bottom: 15px;
                        }

                        .card h2 {
                            color: #667eea;
                            margin-bottom: 10px;
                        }

                        .card p {
                            font-size: 15px;
                            margin: 0;
                        }

                    </style>

                </head>


                <body>

                    <nav>

                        <div class="logo">
                            🎓 StudentApp
                        </div>

                        <div>

                            <a href="/hello">🏠 Home</a>

                            <a href="/students">👨‍🎓 Students</a>

                            <a href="/courses">📚 Courses</a>

                            <a href="/reports">📊 Reports</a>

                        </div>

                    </nav>


                    <div class="hero">

                        <div class="hero-icon">
                            🎓
                        </div>

                        <h1>
                            Student Management System
                        </h1>

                        <p>
                            Welcome to our Spring Boot Student Application
                        </p>

                        <a class="button" href="/students">
                            👨‍🎓 Manage Students
                        </a>


                        <div class="cards">

                            <div class="card">

                                <div class="card-icon">
                                    👨‍🎓
                                </div>

                                <h2>Students</h2>

                                <p>
                                    Add and manage student information
                                </p>

                            </div>


                            <div class="card">

                                <div class="card-icon">
                                    📚
                                </div>

                                <h2>Courses</h2>

                                <p>
                                    View available courses
                                </p>

                            </div>


                            <div class="card">

                                <div class="card-icon">
                                    📊
                                </div>

                                <h2>Reports</h2>

                                <p>
                                    View student statistics
                                </p>

                            </div>

                        </div>

                    </div>

                </body>

                </html>
                """;
    }


    // =========================================================
    // STUDENTS PAGE
    // =========================================================

    @GetMapping(value = "/students", produces = "text/html")
    public String students() {

        StringBuilder studentRows = new StringBuilder();

        int count = 1;

        for (String student : students) {

            String[] data = student.split("\\|");

            studentRows.append("""
                    <tr>

                        <td>""")
                    .append(count)
                    .append("""
                        </td>

                        <td>""")
                    .append(data[0])
                    .append("""
                        </td>

                        <td>""")
                    .append(data[1])
                    .append("""
                        </td>

                        <td>""")
                    .append(data[2])
                    .append("""
                        </td>

                        <td>""")
                    .append(data[3])
                    .append("""
                        </td>

                    </tr>
                    """);

            count++;
        }


        if (students.isEmpty()) {

            studentRows.append("""
                    <tr>

                        <td colspan="5"
                            style="text-align:center;padding:30px;color:#777;">

                            No students registered yet.

                        </td>

                    </tr>
                    """);
        }


        return """
                <!DOCTYPE html>
                <html>

                <head>

                    <title>Student Registration</title>

                    <style>

                        * {
                            box-sizing: border-box;
                            font-family: Arial, sans-serif;
                        }

                        body {
                            margin: 0;
                            background: #f3f4ff;
                        }

                        nav {
                            background: white;
                            padding: 20px 50px;
                            display: flex;
                            justify-content: space-between;
                            align-items: center;
                            box-shadow: 0 3px 15px rgba(0,0,0,0.1);
                        }

                        .logo {
                            font-size: 25px;
                            font-weight: bold;
                            color: #667eea;
                        }

                        nav a {
                            text-decoration: none;
                            margin-left: 25px;
                            color: #444;
                            font-weight: bold;
                        }

                        nav a:hover {
                            color: #667eea;
                        }

                        .container {
                            width: 90%;
                            max-width: 1100px;
                            margin: 40px auto;
                        }

                        .form-box {
                            background: white;
                            padding: 40px;
                            border-radius: 20px;
                            box-shadow: 0 10px 30px rgba(0,0,0,0.12);
                        }

                        h1 {
                            text-align: center;
                            color: #667eea;
                            margin-bottom: 30px;
                        }

                        .form-row {
                            display: flex;
                            gap: 20px;
                            margin-bottom: 20px;
                        }

                        .form-group {
                            flex: 1;
                        }

                        label {
                            display: block;
                            margin-bottom: 8px;
                            font-weight: bold;
                            color: #444;
                        }

                        input,
                        select {
                            width: 100%;
                            padding: 13px;
                            border: 1px solid #ccc;
                            border-radius: 8px;
                            font-size: 16px;
                        }

                        input:focus,
                        select:focus {
                            outline: none;
                            border-color: #667eea;
                        }

                        button {
                            width: 100%;
                            padding: 15px;
                            margin-top: 10px;
                            background: #667eea;
                            color: white;
                            border: none;
                            border-radius: 10px;
                            font-size: 18px;
                            font-weight: bold;
                            cursor: pointer;
                        }

                        button:hover {
                            background: #764ba2;
                        }

                        .table-box {
                            background: white;
                            margin-top: 30px;
                            padding: 30px;
                            border-radius: 20px;
                            box-shadow: 0 10px 30px rgba(0,0,0,0.12);
                        }

                        table {
                            width: 100%;
                            border-collapse: collapse;
                            margin-top: 20px;
                        }

                        th {
                            background: #667eea;
                            color: white;
                            padding: 15px;
                        }

                        td {
                            padding: 15px;
                            border-bottom: 1px solid #ddd;
                            text-align: center;
                        }

                        tr:hover {
                            background: #f5f7ff;
                        }

                        .back {
                            display: inline-block;
                            margin-top: 25px;
                            color: #667eea;
                            text-decoration: none;
                            font-weight: bold;
                        }

                        @media(max-width:700px) {

                            nav {
                                flex-direction: column;
                                gap: 15px;
                            }

                            nav a {
                                margin: 5px;
                            }

                            .form-row {
                                flex-direction: column;
                            }

                            .container {
                                width: 95%;
                            }

                        }

                    </style>

                </head>


                <body>


                    <nav>

                        <div class="logo">
                            🎓 StudentApp
                        </div>

                        <div>

                            <a href="/hello">🏠 Home</a>

                            <a href="/students">👨‍🎓 Students</a>

                            <a href="/courses">📚 Courses</a>

                            <a href="/reports">📊 Reports</a>

                        </div>

                    </nav>


                    <div class="container">


                        <div class="form-box">

                            <h1>
                                👨‍🎓 Student Registration
                            </h1>


                            <form action="/students/save" method="post">


                                <div class="form-row">

                                    <div class="form-group">

                                        <label>
                                            Student Name
                                        </label>

                                        <input
                                            type="text"
                                            name="name"
                                            placeholder="Enter student name"
                                            required>

                                    </div>


                                    <div class="form-group">

                                        <label>
                                            Email
                                        </label>

                                        <input
                                            type="email"
                                            name="email"
                                            placeholder="Enter email address"
                                            required>

                                    </div>

                                </div>


                                <div class="form-row">

                                    <div class="form-group">

                                        <label>
                                            Phone Number
                                        </label>

                                        <input
                                            type="text"
                                            name="phone"
                                            placeholder="Enter phone number"
                                            required>

                                    </div>


                                    <div class="form-group">

                                        <label>
                                            Course
                                        </label>

                                        <select name="course" required>

                                            <option value="">
                                                Select Course
                                            </option>

                                            <option value="Java">
                                                Java
                                            </option>

                                            <option value="Spring Boot">
                                                Spring Boot
                                            </option>

                                            <option value="Python">
                                                Python
                                            </option>

                                            <option value="Web Development">
                                                Web Development
                                            </option>

                                        </select>

                                    </div>

                                </div>


                                <button type="submit">
                                    ➕ Add Student
                                </button>


                            </form>

                        </div>



                        <div class="table-box">

                            <h1>
                                📋 Registered Students
                            </h1>


                            <table>

                                <tr>

                                    <th>
                                        #
                                    </th>

                                    <th>
                                        Name
                                    </th>

                                    <th>
                                        Email
                                    </th>

                                    <th>
                                        Phone
                                    </th>

                                    <th>
                                        Course
                                    </th>

                                </tr>

                                """
                + studentRows.toString()
                + """

                            </table>


                            <a class="back" href="/hello">
                                🏠 Back to Home
                            </a>

                        </div>


                    </div>

                </body>

                </html>
                """;
    }


    // =========================================================
    // SAVE STUDENT
    // =========================================================

    @PostMapping(value = "/students/save", produces = "text/html")
    public String saveStudent(

            @RequestParam String name,

            @RequestParam String email,

            @RequestParam String phone,

            @RequestParam String course) {


        String studentDetails =
                name + "|" + email + "|" + phone + "|" + course;


        students.add(studentDetails);


        return """
                <!DOCTYPE html>

                <html>

                <head>

                    <title>Student Added</title>

                    <style>

                        body {
                            margin: 0;
                            font-family: Arial;
                            background: linear-gradient(135deg, #667eea, #764ba2);
                            text-align: center;
                            padding-top: 100px;
                        }

                        .success-box {
                            background: white;
                            width: 600px;
                            max-width: 90%;
                            margin: auto;
                            padding: 50px;
                            border-radius: 25px;
                            box-shadow: 0 20px 50px rgba(0,0,0,0.3);
                        }

                        .icon {
                            font-size: 70px;
                        }

                        h1 {
                            color: #667eea;
                        }

                        p {
                            color: #555;
                            font-size: 18px;
                        }

                        .button {
                            display: inline-block;
                            margin-top: 20px;
                            padding: 15px 30px;
                            background: #667eea;
                            color: white;
                            text-decoration: none;
                            border-radius: 30px;
                            font-weight: bold;
                        }

                        .button:hover {
                            background: #764ba2;
                        }

                    </style>

                </head>


                <body>


                    <div class="success-box">

                        <div class="icon">
                            ✅
                        </div>

                        <h1>
                            Student Added Successfully!
                        </h1>

                        <p>
                            Student Name: <b>"""
                + name
                + """
                            </b>
                        </p>

                        <p>
                            Course: <b>"""
                + course
                + """
                            </b>
                        </p>


                        <a class="button" href="/students">
                            👨‍🎓 View Students
                        </a>


                        <a class="button" href="/hello">
                            🏠 Home
                        </a>


                    </div>


                </body>

                </html>
                """;
    }


    // =========================================================
    // COURSES PAGE
    // =========================================================

    @GetMapping(value = "/courses", produces = "text/html")
    public String courses() {

        return """
                <!DOCTYPE html>

                <html>

                <head>

                    <title>Courses</title>

                    <style>

                        body {
                            margin: 0;
                            font-family: Arial;
                            background: #f3f4ff;
                        }

                        nav {
                            background: white;
                            padding: 20px;
                            text-align: center;
                            box-shadow: 0 3px 15px rgba(0,0,0,0.1);
                        }

                        nav a {
                            text-decoration: none;
                            margin: 20px;
                            color: #444;
                            font-weight: bold;
                        }

                        .container {
                            width: 80%;
                            max-width: 900px;
                            margin: 50px auto;
                            background: white;
                            padding: 50px;
                            border-radius: 25px;
                            text-align: center;
                            box-shadow: 0 10px 30px rgba(0,0,0,0.15);
                        }

                        h1 {
                            color: #667eea;
                        }

                        .course {
                            padding: 20px;
                            margin: 15px;
                            background: #f3f4ff;
                            border-radius: 15px;
                            font-size: 20px;
                        }

                    </style>

                </head>


                <body>


                    <nav>

                        <a href="/hello">🏠 Home</a>

                        <a href="/students">👨‍🎓 Students</a>

                        <a href="/courses">📚 Courses</a>

                        <a href="/reports">📊 Reports</a>

                    </nav>


                    <div class="container">

                        <h1>
                            📚 Available Courses
                        </h1>


                        <div class="course">
                            ☕ Java Programming
                        </div>

                        <div class="course">
                            🌱 Spring Boot
                        </div>

                        <div class="course">
                            🐍 Python Programming
                        </div>

                        <div class="course">
                            🌐 Web Development
                        </div>


                    </div>


                </body>

                </html>
                """;
    }


    // =========================================================
    // REPORTS PAGE
    // =========================================================

    @GetMapping(value = "/reports", produces = "text/html")
    public String reports() {

        return """
                <!DOCTYPE html>

                <html>

                <head>

                    <title>Reports</title>

                    <style>

                        body {
                            margin: 0;
                            font-family: Arial;
                            background: linear-gradient(135deg, #667eea, #764ba2);
                            min-height: 100vh;
                        }

                        nav {
                            background: white;
                            padding: 20px;
                            text-align: center;
                        }

                        nav a {
                            text-decoration: none;
                            margin: 20px;
                            color: #444;
                            font-weight: bold;
                        }

                        .container {
                            width: 80%;
                            max-width: 800px;
                            margin: 60px auto;
                            background: white;
                            padding: 60px;
                            border-radius: 25px;
                            text-align: center;
                            box-shadow: 0 20px 50px rgba(0,0,0,0.3);
                        }

                        h1 {
                            color: #667eea;
                        }

                        .number {
                            font-size: 70px;
                            font-weight: bold;
                            color: #764ba2;
                            margin: 30px;
                        }

                        .text {
                            font-size: 22px;
                            color: #555;
                        }

                    </style>

                </head>


                <body>


                    <nav>

                        <a href="/hello">🏠 Home</a>

                        <a href="/students">👨‍🎓 Students</a>

                        <a href="/courses">📚 Courses</a>

                        <a href="/reports">📊 Reports</a>

                    </nav>


                    <div class="container">

                        <h1>
                            📊 Student Reports
                        </h1>


                        <div class="number">
                """
                + String.valueOf(students.size())
                + """
                        </div>


                        <div class="text">
                            Total Registered Students
                        </div>


                    </div>


                </body>

                </html>
                """;
    }

}