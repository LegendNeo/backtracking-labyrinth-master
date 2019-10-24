//Niklas Keller 2104858

package de.ur.adp.backtracking.labyrinth;

public class StudentsLaybrinthSolver implements LabyrinthSolver {

    private boolean[][] labyrinth;
    private int count = 0; // gets higher by 1 if u take a step
    // always if you go a certain way, f.e. from point 'A' to 'B', it gets saved in the array[][]
    private boolean[][] knownWay = new boolean[13][13];
    private int lastPoint = -1; // lastPoint always saves the last point where u have been

    private void fillLabyrinth() {
        // labyrinth represents from which points u have access to other certain points
        // the row is for the point ur at, and every col that is true in this row, u have access to
        //f.e. if labyrinth[0][1] = true, that means you can go from point 0('A') to point 1('B')
        labyrinth = new boolean[13][13];

        labyrinth[0][1] = true; labyrinth[0][4] = true; // A
        labyrinth[1][0] = true; labyrinth[1][3] = true; // B
        labyrinth[2][3] = true; // C
        labyrinth[3][1] = true; labyrinth[3][2] = true; labyrinth[3][4] = true; // D
        labyrinth[3][9] = true; labyrinth[3][10] = true; // D
        labyrinth[4][0] = true; labyrinth[4][3] = true; // E
        labyrinth[4][5] = true; labyrinth[4][6] = true; // E
        labyrinth[5][4] = true; // F
        labyrinth[6][4] = true; labyrinth[6][7] = true; labyrinth[6][8] = true; // G
        labyrinth[7][6] = true; // H
        labyrinth[8][6] = true; // I
        labyrinth[9][3] = true; labyrinth[9][10] = true; // J
        labyrinth[10][3] = true; labyrinth[10][12] = true; // K
        labyrinth[10][9] = true; labyrinth[10][11] = true; // K
        labyrinth[11][10] = true; labyrinth[11][12] = true; // L
        labyrinth[12][10] = true; labyrinth[12][11] = true; // M
    }
    @Override
    public char[] solve(char from, char to) {
        fillLabyrinth();
        char[] way = new char[32]; // in way[] the steps you go are saved
        int iFrom = charToInt(from); // converts char from to an integer
        int iTo = charToInt(to); // converts char to to an integer

        solve(way,iFrom,iTo); // calls recursive method

        return way;
    }

    private boolean solve(char[] way,int from, int to) {
        if(from == to) { // if from == to, u are at ur end point, and the method returns true

            setCharArray(way, from); // add move to way[]
            return true;
        }
        for(int i = 0; i < labyrinth.length; i++) { // checks every point u can move to

            // if 1. there is no connection between the 2 points, or if 2. you already went this way,
            // or if 3. u came from the point you wanna go to, continue and search next available point
            if(!labyrinth[from][i] || knownWay[from][i] || i==lastPoint) {
                continue;
            }

            setCharArray(way, from); // add move to way[]
            knownWay[from][i] = true; // saves way as knowWay
            lastPoint = from; // saves from in lastPoint

            if(solve(way,i,to)) { // calls solve method with new from value(i)
                return true;
            }
        }
        // if there is no more way you can move, u jump back, which also counts as move
        setCharArray(way,from); // add move to way[]
        return false;
    }

    // method saves every step you take in the way[] array
    private void setCharArray(char[] way, int from) {
        char cFrom = intToChar(from);
        way[count] = cFrom;
        count++;
    }

    private int charToInt(char c){ // turns char value to int value
        c = Character.toLowerCase(c);
        return (int) c -97;
    }

    private char intToChar(int i){ // turns int value to char value, also always uppercase
        i+=97;
        char c = (char) i;
        c = Character.toUpperCase(c);
        return c;
    }
}
