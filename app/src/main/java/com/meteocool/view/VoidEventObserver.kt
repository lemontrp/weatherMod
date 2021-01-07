package com.meteocool.view

import androidx.lifecycle.Observer

/**
 * An [Observer] for [Event]s, simplifying the pattern of checking if the [Event]'s content has
 * already been handled.
 *
 * [onEventUnhandledContent] is *only* called if the [Event]'s contents has not been handled.
 */
class VoidEventObserver<T> (private val onEventUnhandledContent: () -> Unit) : Observer<VoidEvent> {
    override fun onChanged(event: VoidEvent) {
        if(!event.hasBeenHandled()){
            onEventUnhandledContent()
        }
    }
}