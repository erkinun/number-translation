# number to english translation (1 to 1000)

This a simple tool for learning purposes; it simply accepts command line entries of numbers between 1 to 1000 from the user and prints out a grammatically correct english translation of the number. 

## Requirements
Make sure you have JDK 8+ installed on your machine. Project also requires leiningen build tool so download it from https://leiningen.org/. 

## Installation & Usage
Download via git clone and then run `lein run` at the command line. Run `lein test` to run tests.

Alternatively you can run `lein uberjar` and this will create a standalone jar to be distributed. This can be run with the following command: `java -jar target/uberjar/num--0.1.0-SNAPSHOT-standalone.jar`.

When the tool is started, user can follow the directions on screen.

## License


This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
