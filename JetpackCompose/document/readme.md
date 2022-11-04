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
