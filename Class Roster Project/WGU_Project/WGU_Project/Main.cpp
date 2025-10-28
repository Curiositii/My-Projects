#include "Roster.h"
#include <iostream>
using namespace std;

int main() {

	cout << "C-867: Scripting & Programming, C++ language used" << endl;
	cout << "WGU ID: 012290334 " << "Dakota May" << endl;

	Roster classRoster;

	const string studentData[] =
	{ "A1,John,Smith,John1989@gm ail.com,20,30,35,40,SECURITY",
	"A2,Suzan,Erickson,Erickson_1990@gmailcom,19,50,30,40,NETWORK",
	"A3,Jack,Napoli,The_lawyer99yahoo.com,19,20,40,33,SOFTWARE",
	"A4,Erin,Black,Erin.black@comcast.net,22,50,58,40,SECURITY",
	"A5,Dakota,May,dmay121@wgu.edu,27,25,30,35,SOFTWARE" };

	for (const string& student : studentData) {
		classRoster.parseData(student);
	}
	cout << endl;
	classRoster.printAll();

	cout << endl;
	classRoster.printInvalidEmails();

	cout << endl;
	for (int i = 0; i < 5; i++) {
		if (classRoster.getStudent(i) != nullptr) {
			classRoster.printAverageDaysInCourse(classRoster.getStudent(i)->getStudentID());
		}
	}

	cout << endl;
	classRoster.printByDegreeProgram(SOFTWARE);

	cout << endl;
	classRoster.remove("A3");
	classRoster.printAll();

	cout << endl;
	classRoster.remove("A3");



	return 0;
}