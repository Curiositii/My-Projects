#include "Student.h"
using namespace std;

Student::Student(string userStudentId, string userFirst, string userLast, string userEmail, int userAge, int courseDayOne, int courseDayTwo, int courseDayThree, DegreeProgram userDegree) {
	studentID = userStudentId;
	firstName = userFirst;
	lastName = userLast;
	emailAddress = userEmail;
	age = userAge;
	numDays[0] = courseDayOne;
	numDays[1] = courseDayTwo;
	numDays[2] = courseDayThree;
	degree = userDegree;
}
string Student::getStudentID() const {
	return studentID;
}

string Student::getStudentFirst() const {
	return firstName;
}

string Student::getStudentLast() const {
	return lastName;
}

string Student::getStudentEmail() const {
	return emailAddress;
}

int Student::getStudentAge() const {
	return age;
}

const int* Student::getStudentCourseDays() const {
	return numDays;
}

DegreeProgram Student::getStudentDegree() const {
	return degree;
}

string Student::degreeConverstion(DegreeProgram degree) const {
	switch (degree) {
	case SECURITY: return "SECURITY";
	case NETWORK: return "NETWORK";
	case SOFTWARE: return "SOFTWARE";
	}
}

void Student::setStudentID(string userStudentID) {
	studentID = userStudentID;
}

void Student::setStudentFirst(string userFirst) {
	firstName = userFirst;
}

void Student::setStudentLast(string userLast) {
	lastName = userLast;
}

void Student::setStudentEmail(string userEmail) {
	emailAddress = userEmail;
}

void Student::setStudentAge(int userAge) {
	age = userAge;
}

void Student::setStudentCourseDays(int courseDayOne, int courseDayTwo, int courseDayThree) {
	numDays[0] = courseDayOne;
	numDays[1] = courseDayTwo;
	numDays[2] = courseDayThree;
}

void Student::setStudentDegree(DegreeProgram userDegree) {
	degree = userDegree;
}

void Student::print() const {
	cout << studentID << "  " << "First Name: " << firstName << "  " << "Last Name: " << lastName << "  " << "Age: " << age << "  " << "daysInCourse: {" << numDays[0] << ", " << numDays[1] << ", " << numDays[2] << "}  "
		<< "Degree Program: " << degreeConverstion(getStudentDegree()) << endl;
}