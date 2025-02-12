#ifndef ROSTER_H
#define ROSTER_H
#include "Student.h"
using namespace std;

class Roster {
private:
	Student* classRosterArray[5];

public:
	Roster();

	~Roster();

	void parseData(const string& studentData);

	void add(string userStudentId, string userFirst, string userLast, string userEmail, int userAge, int courseDayOne, int courseDayTwo, int courseDayThree, DegreeProgram userDegree);

	void remove(string userStudentId);

	Student* getStudent(int index);

	void printAll();

	void printAverageDaysInCourse(string userStudentId);

	void printInvalidEmails();

	void printByDegreeProgram(DegreeProgram userDegree);
};
#endif
