#include "Roster.h"
#include "Student.h"
#include "Degree.h"
#include <iostream>
#include <cstring>
#include <sstream>
using namespace std;

Roster::Roster() {
	for (int i = 0; i < 5; i++) {
		classRosterArray[i] = nullptr;
	}
}

Roster::~Roster() {
	for (int i = 0; i < 5; i++) {
		if (classRosterArray[i] != nullptr) {
			delete classRosterArray[i];
			classRosterArray[i] = nullptr;
		}
	}
}

void Roster::parseData(const string& studentData) {
		stringstream ss;
		string userStudentId;
		string userFirst;
		string userLast;
		string userEmail;
		int userAge;
		int courseDayOne;
		int courseDayTwo;
		int courseDayThree;
		string userDegree;
		DegreeProgram degree;

		ss.str(studentData);

		getline(ss, userStudentId, ',');
		getline(ss, userFirst, ',');
		getline(ss, userLast, ',');
		getline(ss, userEmail, ',');

		ss >> userAge;
		ss.ignore();
		ss >> courseDayOne;
		ss.ignore();
		ss >> courseDayTwo;
		ss.ignore();
		ss >> courseDayThree;
		ss.ignore();

		getline(ss, userDegree);

		if (userDegree == "SECURITY") {
			degree = SECURITY;
		}
		else if (userDegree == "NETWORK") {
			degree = NETWORK;
		}
		else if (userDegree == "SOFTWARE") {
			degree = SOFTWARE;
		}

		add(userStudentId, userFirst, userLast, userEmail, userAge, courseDayOne, courseDayTwo, courseDayThree, degree);
}

void Roster::add(string userStudentId, string userFirst, string userLast, string userEmail, int userAge, int courseDayOne, int courseDayTwo, int courseDayThree, DegreeProgram userDegree) {
	for (int i = 0; i < 5; i++) {
		if (classRosterArray[i] == nullptr) {
			classRosterArray[i] = new Student(userStudentId, userFirst, userLast, userEmail, userAge, courseDayOne, courseDayTwo, courseDayThree, userDegree);
			return;
		}
	}
}

void Roster::remove(string userStudentId) {
	bool studentFound = false;
	for (int i = 0; i < 5; i++) {
		if (classRosterArray[i] != nullptr && classRosterArray[i]->getStudentID() == userStudentId) {
			delete classRosterArray[i];
			classRosterArray[i] = nullptr;
			studentFound = true;
			return;
		}
	}
	if (studentFound == false) {
		cout << "Student was not found" << endl;
	}
}

void Roster::printAll() {
	for (int i = 0; i < 5; i++) {
		if (classRosterArray[i] != nullptr) {
			classRosterArray[i]->print();
		}
	}
}

Student* Roster::getStudent(int index) {
	if (index >= 0 && index < 5) {
		return classRosterArray[index];
	}
}

void Roster::printAverageDaysInCourse(string userStudentId) {
	for (int i = 0; i < 5; i++) {
		if (classRosterArray[i]->getStudentID() == userStudentId) {
			const int* courseDays = classRosterArray[i]->getStudentCourseDays();
			int averageDays = (courseDays[0] + courseDays[1] + courseDays[2]) / 3;
			cout << "The student's average number of days in the three courses is " << averageDays << endl;
		}
	}
}

void Roster::printInvalidEmails() {
	for (int i = 0; i < 5; i++) {
		string studEmails = classRosterArray[i]->getStudentEmail();
		const char* emailC = studEmails.c_str();
		if (strchr(emailC, '@') != NULL && strchr(emailC, '.') != NULL && strchr(emailC, ' ') == NULL) {
			continue;
		}
		else {
			cout << "This email is invalid: " << studEmails << endl;
		}
	}
}

void Roster::printByDegreeProgram(DegreeProgram userDegree) {
	for (int i = 0; i < 5; i++) {
		if (classRosterArray[i]->getStudentDegree() == userDegree) {
			classRosterArray[i]->print();
		}
	}
}