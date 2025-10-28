#ifndef STUDENT_H
#define STUDENT_H
#include <string>
#include <iostream>
#include "Degree.h"
using namespace std;

class Student {

public:

	Student(string userStudentId, string userFirst, string userLast, string userEmail, int userAge, int courseDayOne, int courseDayTwo, int courseDayThree, DegreeProgram userDegree);

	string getStudentID() const;

	string getStudentFirst() const;

	string getStudentLast() const;

	string getStudentEmail() const;

	int getStudentAge() const;

	const int* getStudentCourseDays() const;

	DegreeProgram getStudentDegree() const;

	string degreeConverstion(DegreeProgram degree) const;

	void setStudentID(string userStudentID);

	void setStudentFirst(string userFirst);

	void setStudentLast(string userLast);

	void setStudentEmail(string userEmail);

	void setStudentAge(int userAge);

	void setStudentCourseDays(int courseDayOne, int courseDayTwo, int courseDayThree);

	void setStudentDegree(DegreeProgram userDegree);

	void print() const;

private:
	string studentID;
	string firstName;
	string lastName;
	string emailAddress;
	int age;
	int numDays[3];
	DegreeProgram degree;
};

#endif
