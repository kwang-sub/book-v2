package ch04

class ViewButton: View2 {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {

    }

    class ButtonState: State
}