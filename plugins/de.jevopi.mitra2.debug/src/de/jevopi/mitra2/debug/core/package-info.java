/**
 * The Mitra execution engine, i.e. the interpreter, is controlled by
 * the {@link MitraDebugProxy} (in the following called debugger) via the
 * {@link de.feu.mitra.engine.debugapi.IDebuggable} interface. The interpreter
 * is accessed via a thread {@link MitraDebugProxy#ProcessEventHandler)},
 * events are received via a {@link java.util.concurrent.LinkedBlockingQueue}.
 * <p>
 * The state pattern is used for handling the different states of the debugger,
 * these states (implementing {@link IDebuggerState} and extending
 * {@link AbstractDebuggerState}) also handle the transitions. Using this
 * pattern was suggested by Kossak in
 * <p>
 * Kossak, Ingo: Konzeption und Realisierung eines Debuggers für eine 
 *    domänenspezifische Sprache auf Basis von openArchitectureWare. Hagen, 
 *    Germany, FernUniversität in Hagen, Bachelor, November 2008
 * </p>
 * The implementation suggested by Kossak used singleton. This caused problems
 * when running several instances of the debugger or even simply when the 
 * debugger was invoked a second time. Thus the implementation here doesn't 
 * uses the singleton pattern. To avoid to much state instances to be created,
 * the proxy creates one instance per state class and switches between these
 * instances (in {@link MitraDebugProxy#setCurrentState(de.feu.mitra.debug.core.IDebuggerState.StateID)}.
 * </p>
 * 
 * <p>
 * Note: Maybe a complete asynchronous communication should be implemented in 
 * future versions 
 * </p>
 *
 */
package de.jevopi.mitra2.debug.core;

