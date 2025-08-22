import React, { useEffect, useState } from "react"; // Import React and the two hooks we need

export default function FestivalApp() { // Start of our functional component
  const [festival, setFestival] = useState("Diwali"); // State 1: which festival is active (initially "Diwali")
  const [countdown, setCountdown] = useState(5);      // State 2: countdown value in seconds (starts at 5)

  /* Every render 
     This effect has NO dependency array.
     React will run it after EVERY render (first mount + all updates).
     Use this pattern for logging, measuring layout, etc., that should happen on each render.
  */
  useEffect(() => {
    console.log("Festival App Rendered"); // Prints on mount and on every state update that triggers a re-render
  }); //  no dependency array on purpose

  /*  Run once on mount 
     Empty dependency array [] means:
      Run the effect exactly ONCE after the first render (component mount).
      Run the cleanup (if provided) when the component unmounts.
     Use this pattern for one-time startup code (welcome message, initial fetch, subscriptions).
  */
  useEffect(() => {
    console.log("Welcome to Diwali Festival App"); // Also log to the console once
    alert("Welcome to Diwali Festival App");       // Show the welcome alert only once
  }, []); //  empty dependency array = run once on mount

  /*Track a specific dependency
     Dependency array [festival] means:
      Run this effect after first render AND whenever `festival` CHANGES.
      Skip runs if only other state (e.g., countdown) changes.
     Use this pattern to react to a particular piece of state/prop changing.
 */
  useEffect(() => {
    console.log(`Festival changed to ${festival}.`); // Logs only when `festival` value changes
  }, [festival]); // ← depend on festival only

  /*  Timer + cleanup (unmount) 
     We start a 1s interval ONCE ([]). Inside, we update `countdown` safely
     using the functional form of setState (so it uses the latest value).
     The returned function is the CLEANUP. React calls it:
       . when the component UNMOUNTS (since [] never re-runs), OR
       . before running this effect again (if it had dependencies).
     Use this pattern for intervals, timeouts, subscriptions, event listeners.
 */
  useEffect(() => {
    const id = setInterval(() => {                         // Start an interval and keep its id
      setCountdown(prev => (prev > 0 ? prev - 1 : 0));     // Decrease countdown every second down to 0
    }, 1000);

    return () => {                                         // Cleanup function
      clearInterval(id);                                   // Stop the interval to prevent memory leaks / orphan timers
    };
  }, []); //  run once; cleanup runs on unmount

  /* Multiple dependencies (react when either changes) 
     [festival, countdown] means:
     Run after first render AND whenever EITHER `festival` OR `countdown` changes.
     Good for combined logging or side-effects that need both values.
  */
  useEffect(() => {
    console.log(`Festival: ${festival}, Countdown: ${countdown}`); // Log combined state whenever either changes
  }, [festival, countdown]); // ← depend on both

  /* Small helper effect to auto-change festival on 0 countdown
     When countdown hits 0, we change the festival and reset the countdown.
     We depend on BOTH values because the logic uses both.
  */
  useEffect(() => {
    if (countdown === 0) {             // Only act when it reaches zero
      if (festival === "Diwali") {     // First transition: Diwali → Holi
        setFestival("Holi");
        setCountdown(2);               // Shorter countdown to quickly demo changes
      } else if (festival === "Holi") {// Second transition: Holi → Pongal
        setFestival("Pongal");
        setCountdown(5);
      }
      // If already Pongal, do nothing; stays at 0
    }
  }, [countdown, festival]); //  run whenever either changes (needed for the condition)

  // UI 
  return (
    <div
      className="d-flex flex-column align-items-center justify-content-center min-vh-100 bg-light"
    >
      {/* Display current festival and countdown on the page */}
      <h1 className="text-primary">🎉 {festival} Festival 🎉</h1>
      <h2>Countdown: {countdown}</h2>

      {/* A couple of buttons to play with the state (will trigger effects) */}
      <div className="mt-3 d-flex gap-2">
        <button className="btn btn-outline-primary"
                onClick={() => setFestival("Diwali")}>
          Set Diwali
        </button>
        <button className="btn btn-outline-success"
                onClick={() => setFestival("Holi")}>
          Set Holi
        </button>
        <button className="btn btn-outline-warning"
                onClick={() => setFestival("Pongal")}>
          Set Pongal
        </button>
        <button className="btn btn-outline-dark"
                onClick={() => setCountdown(5)}>
          Reset Countdown
        </button>
      </div>
    </div>
  );
}
