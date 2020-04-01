# MK Parts Picker V3.0
A simple mechanical keyboard builder to help you select components using Java.
## Features
**Main Components of a Mechanical Keyboard**:
- Keycaps
- Mechanical Key Switches
- Plate
- Printed Circuit Board
- Case

Using MK Part Picker, plan your build by learning briefly about different components and adding it to a list 
with a rating for *feel*, *sound*, and *weight* after a compatibility check.

The application will focus on two things: providing information and rating a keyboard build. Beginners interested 
in building their first keyboard will be able to use this application as a single reference, as it contains information
and allows the user to plan a future build. The application will take inputs and provide information about various 
components of a keyboard; it will also be able to store chosen components to give the user and idea of how the keyboard
will feel and sound.

This project is important to me because I have built computers and keyboards before; I have always wished that there 
was a simple application that would allow me to learn about and choose components for my project. 

## User Stories
- As a user, I want to be able to retrieve information about each component of a keyboard.

- As a user, I want to be able to select a component for my keyboard.

- As a user, I want to be able to see my selected components in my keyboard.

- As a user, I want to be able to have my keyboard rated, giving me an idea about my build.

- As a user, I want to be able to save my keyboard build to a file

- As a user, I want to be able to optionally load my keyboard build from file when the program starts

## Instructions for Grader
- You can generate the first required event by clicking the "Build" button, which allows you to select components to 
add to Keyboard through dropdown menus.

- You can generate the second required event by clicking the "Print" button, which shows you all of the components 
chosen for the keyboard.

- You can locate my visual component by running the GUI: a visual component is seen at the main menu. Also, a visual 
component is shown to the user during the build process (when you select each component, a photo appears to aid your 
choices).

- You can save the state of my application by clicking "File" in the menu bar at the main menu.

- You can reload the state of my application by clicking "File" in the menu bar at the main menu.
## Phase 4: Task 2
I have chosen to go with Option #2: including type hierarchies in my code. I decided to set up two type hierarchies to 
abstract a couple of methods and to increase cohesion in my model class.
Specifically, in ui.gui: the classes apart of the first type hierarchy are DialogBox, PrintBox, RateBox, AlertBox, and 
ExitConfirmationBox. My second type hierarchy includes: Rateable, Keyboard, Case, Keycaps, Plate, and Switches.
## Phase 4: Task 3
My Keyboard class was one area where there was very poor cohesion because the Keyboard class has methods that rated the
individual components. To increase cohesion in this area, I introduced a type hierarchy with Rateable and therefore 
increased cohesion by making each individual component rateable. The individual components now may be rated separate 
from one another, and the keyboard also has its own rate method.

I also removed PrintBox and RateBox as they were essentially the same (I was able to abstract this into DialogBox, and 
adding a new parameter to account for the width differences). I extended AlertBox and ExitConfirmationBox to this new
DialogBox, as they are similar except with an added modality of persisting until closed.

The final area identified that could use improvements in cohesion was found in the GUI class. There were a couple of 
methods like displayPrint and displayRate that retrieved information about the keyboard which were moved into a 
refactored class called InformationHandler, which deals with information about the keyboard; this lead to an increased 
cohesion within the information class.