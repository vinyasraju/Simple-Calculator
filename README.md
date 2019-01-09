# windows-calculator-java

Program is a a replica of the Windows 7 Programming Calculator.

1) Calculator will operate with the number buttons on the keypad and will do operations based on input. 

2) The final result of an operation will display once the ‘=’ is pressed; all operations to be done in "Dec" mode.

3) Basic conversions to Hex, Oct, and Binary is supported, however, operations in those bases is not supported. 

4) "C" button will clear the entire operation, "CE" will delete previous entry but not operation,

   "<-" (Backspace) will delete the right-most digit of the current input. 
   
5) Order of Operations is implemented into the calculator; decimal results and negative numbers also accounted for. 2's

   complement currently has issues when translating negative numbers to other bases. 

6) The 64-bit binary panel will dynamically display the outputs, however, overflow is not accounted for. 

7) The menu bar and all submenus operate as expected. 
