The doc file is on below link 

https://docs.google.com/document/d/11I94ixz1qC3b33R9drlY-cEDcCpEi4GrnMfILfA3tIg/edit#

Recomposition:

- It allows the whole UI to be rebuilt and the state to be changed in an imperative approach
- All the children will be rebuilt


State: 
- It is very important
- State is hot of UI construction 
- It allows to rebuilt the UIs and update the widget the ui looks for the user
- Definition: State in app is any value that value that can change over time

State as part of recomposition:
- state in an app is any value that can change over time
-  Unidirectional data flow - event - update state - display state
-  UI-state flow is unidirectional so it has advantages like
    - testability,
    - state encapsulation - state update from one place
    - UI consistency - state immediately reflect on screen by observer
- mutableStateListOf
    - To manage state, keep list in mutableStateListOf
   
- remember block in state
    - After recomposition we want to remember state then use remember block
    - remember block is special block in jetpack compose
    - The state will be remember over the recomposition
   
- Lift up state (State hoisting)
    - MainScreen composable function is main entry point for states and state updates which happen on click
    
- 45. Introduction to view model and live data
    - It is a part of jetpack framework (jetpack component)
    - View model - it is a class that is responsible for preparing and managing the state of the UI for fragments and Activities
    
- View model has a relationship with the view to prepare data and has to be displayed as a presentation role in order to display on the screen
      View binds to view model and expect some input data like may be text, list,
      The view is dependent on the UI state.

   -  Live data- It is a lifecycle-aware observable data holder
   - Fragment and activity observe the changes of live data. 
   - Live data does not know who is observing it. It has to notify if it’s change 