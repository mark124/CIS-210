/* Airport class
   Anderson, Franceschi
   Mark Johnson
*/

public class Airport
{
// Instance variables
private String airportCode;
private int gates;

// 1. ***** Add a static class variable *****
//  countAirports is an int
//  assign an initial value of 0
// Part 1 student code starts here:

private static int countAirports = 0;

// Part 1 student code ends here.

// 2. ***** Modify this method *****
// Default constructor:
// method name: Airport
// return value:  none
// parameters: none
// function: sets the airportCode to an empty String
//    ***** adds 1 to countAirports class variable
public Airport()
{
  airportCode = "";
  // Part 2 student code starts here:

  Airport.countAirports++;


  // Part 2 student code ends here.
}

// 3. ***** Modify this method *****
// Overloaded constructor:
// method name: Airport
// return value: none
// parameters:  a String startAirportCode and an int startGates
// function: calls the setAirportCode method, passing the
//      startAirportCode parameter;
//      calls the setGates method, passing the startGates parameter
//    ***** adds 1 to countAirports class variable
public Airport(String startAirportCode, int startGates)
{
  airportCode = startAirportCode;
  setGates(startGates);
  // Part 3 student code starts here:

  Airport.countAirports++;


  // Part 3 student code ends here.
}

// Accessor method for the airportCode instance variable
// method name: getAirportCode
// return value: String
// parameters: none
// function: returns airportCode
public String getAirportCode()
{
  return airportCode;
}

// Accessor method for the gates instance variable
// method name: getGates
// return value: int
// parameters: none
// function: returns gates
public int getGates()
{
  return gates;
}

// 4. ***** Write this static method *****
// Accessor method for the countAirports class variable
// method name: getCountAirports
// return value: int
// parameters: none
// function: returns countAirports
// Part 4 student code starts here:

public static int getCountAirports() 
{
  return countAirports;
}

// Part 4 student code ends here.

// Mutator method for the airportCode instance variable
// method name: setAirportCode
// return value: void
// parameters: String newAirportCode
// function: assigns airportCode the value of the
//                    newAirportCode parameter
public void setAirportCode(String newAirportCode)
{
  airportCode = newAirportCode;
}

// Mutator method for the gates instance variable
// method name: setGates
// return value:  void
// parameters: int newGates
// function: validates the newGates parameter.
//   if newGates is greater than or equal to 0,
//      sets gates to newGates;
//      otherwise, prints an error message to System.err
//      and does not change value of gates
public void setGates(int newGates)
{
  if (newGates  <  0)
  {
    System.err.println("Gates must be at least 0");
    System.err.println("Value of gates unchanged.");
    return;
  }

  gates = newGates;
}

// 5. ***** Write this method *****
// method name:  toString
// return value: String
// parameters: none
// function:  returns a String that contains the airportCode
//    and gates
// Part 5 student code starts here:

public String toString() 
{
  return "Airport code : "+this.getAirportCode()+"; Number of Gates: "+this.getGates();
}

// Part 5 student code ends here.

// 6. ***** Write this method *****
// method name: equals
// return value: boolean
// parameter:  Airport object
// function:  returns true if airportCode
//     and gates in this object
//    are equal to those in the parameter object;
//    returns false otherwise
// Part 6 student code starts here:

public int hashCode() 
{ 
  final int prime = 31;
  int result = 1;
  result = prime * result + ((airportCode == null) ? 0 : airportCode.hashCode());
  result = prime * result + gates;
  return result;
}

public boolean equals(Object obj) 
{
  if (this == obj)
    return true;
  if (obj == null)
    return false;
  if (getClass() != obj.getClass())
    return false;
  
Airport other = (Airport) obj;

  if (airportCode == null) 
  {
    if (other.airportCode != null)
      return false;
  } 
  else if (!airportCode.equals(other.airportCode))
    return false;
  if (gates != other.gates)
    return false;
  return true;
}

// Part 6 student code ends here.

}  // end of Airport class definition
