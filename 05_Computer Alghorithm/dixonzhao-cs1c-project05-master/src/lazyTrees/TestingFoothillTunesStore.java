package lazyTrees;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import java.io.File;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Simulates the music scenario of adding, removal songs to store and find song by title<p>
 *
 * Implements BST with lazy deletion to keep track of total inventory ("deleted" + non deleted)
 * and current inventory (non deleted only).
 *
 * @author Foothill College, Zhili Zhao
 */
public class TestingFoothillTunesStore {

    public static final boolean SHOW_DETAILS = true;

    // TODO: Define the functor class PrintObject to traverse and print out data
    //       from LazySearchTree.
    PrintObject<song> printObject = new PrintObject<song>();

    // The data structure, which we use to add and remove items.
    private FoothillTunesStore inventory;

    /**
     * Instantiates inventory to be a LazySearchTree of Item objects.
     */
    public TestingFoothillTunesStore()
    {
        inventory = new FoothillTunesStore();
    }

    /**
     * Add a new item with the name as in parameter into inventory. If there is
     * already same name product, increase amount by one, if not create a new object.
     * @param song	The item to be added to the inventory tree.
     */
    public void addToInventory(SongEntry song)
    {
        // Create a temporary object to hold the item.
        song tmp = new song(song);

        // Check if the item is in the inventory tree.
        boolean isFound = inventory.contains(tmp);

        // If the item is not found, add the temporary object as another node (category) to the tree.
        if (!isFound)
        {
            // TODO: Modify insert method to work with lazy deletion such that it updates
            //       both hard and soft sizes.
            inventory.insert(tmp);

            // NOTE: Need to check if the item was lazily deleted, then we need to increment the count
            song found = inventory.find(tmp);
            if (found.getCount() == 0)
            {
                found.incrementCount();
            }
            return;
        }

        // If the item is found, increase the number of items in that item category.
        song found = inventory.find(tmp);

        // item was previously in tree, so increment the count
        found.incrementCount();
    }

    /**
     * If the item is in the inventory, decrease the count by one.
     * If only one item is left, remove it from the inventory.
     * @param item		The item to be removed to the inventory tree.
     */
    public void removeFromInventory(SongEntry item)
    {
        song tmp = new song(item);
        boolean isFound = inventory.contains(tmp);

        // check if the item exists in the inventory disregarding lazy deletion
        if (!isFound)
        {
            throw new NoSuchElementException();
        }

        song found = inventory.find(tmp);

        // if the items has zero left in stock,
        // then treat it as if it does not exist in the tree.
        if (found.getCount() == 0)
        {
            throw new NoSuchElementException();
        }
        // if the item has one left in stock,
        // then decrement its count and lazy delete it in the tree.
        else if (found.getCount() == 1)
        {
            found.decrementCount();

            // TODO: Modify to be a lazy deletion remove method, which marks
            //       found nodes as "deleted".
            inventory.remove(tmp);
        }
        // otherwise, simply decrement its count.
        else
        {
            found.decrementCount();
        }
    }


    /**
     * Display the first item and last time of the soft tree in lexical order.
     */
    public void showFirstAndLastItem(String message)
    {
        System.out.println("\n" + message);

        // TODO: Modify the protected methods findMin() and findMax() to implement lazy deletion.
        //       Searches from the root of the tree and return sthe minimum and maximum node that
        //       has NOT been "deleted".
        try
        {
            song min = inventory.findMin();
            System.out.println ( "First item: " + min.toString());
        }
        catch (Exception NoSuchElementException)
        {
            System.out.println("Warning: minimum element not found!");
        }

        try
        {
            song max = inventory.findMax();
            System.out.println ( "Last item: " + max.toString());
        }
        catch (Exception NoSuchElementException)
        {
            System.out.println("Warning: minimum element not found!");
        }

    }

    /**
     * Shows the state of the tree by displaying:
     * - the *hard* inventory, which includes deleted nodes.
     * - the *soft* inventory, which excludes deleted nodes.
     * @param message	Additional details about the state.
     * @param showTree	Set to true if we want to display the contents of the tree
     */
    protected void displayInventoryState(String message, boolean showTree)
    {
        System.out.println("\n" + message);
        System.out.println("\"hard\" number of unique items (i.e. mSizeHard) = " + inventory.sizeHard());
        System.out.println("\"soft\" number of unique items (i.e. mSize) = " + inventory.size());

        if (!showTree)
            return;

        System.out.println( "\nTesting traversing \"hard\" inventory:");

        // TODO: First, rename the public/private pair traverse() method of LazySearchTree to traverseHard() method.
        //       Then, reuse this public/private pair of methods to traverses the tree
        //       and displays all the nodes.
        // NOTE: Here, we call the public version.
        inventory.traverseHard(printObject);


        System.out.println( "\n\nTesting traversing \"soft\" inventory:");

        // TODO: Define a public/private pair of methods that traverses the tree
        //       and displays only nodes that have not been lazily deleted.
        // NOTE: Here, we call the public version.
        inventory.traverseSoft(printObject);
        System.out.println("\n");
    }

    /**
     * main method, testing for add and delete songs and find specific song based on title
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO: Tests the LazySearchTree by adding and removing items from the inventory

        final String TESTFILE = "resources/songs_first.txt";


        System.out.printf("Test file: %s \n", TESTFILE);

        TestingFoothillTunesStore market = new TestingFoothillTunesStore();

        File infile = new File(TESTFILE);
        String jsonFilePath ="resources/music_genre_subset.json";
         boolean ENABLE_DATA_OUTPUT = false;

        SongEntry[] arrayOfSongs;




        try
        {

            // --------------------
            // parse the JSON file
            FileReader fileReader = new FileReader(jsonFilePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

            JSONArray allSongs = (JSONArray) jsonObject.get("songs");

            // --------------------
            // create an array of all the JSON objects
            arrayOfSongs = new SongEntry[allSongs.size()];

            Iterator<?> iterator = allSongs.iterator();
            int counter = 0;
            while (iterator.hasNext() && counter < arrayOfSongs.length)
            {
                JSONObject currentJson = (JSONObject)iterator.next();
                String title = currentJson.get("title").toString();
                int duration = (int)Math.ceil(Double.parseDouble(currentJson.get("duration").toString()));
                String artist = currentJson.get("artist_name").toString();
                String genre = currentJson.get("genre").toString();

                SongEntry currentSong = new SongEntry(title, duration, artist, genre);
                arrayOfSongs[counter++] = currentSong;
            }



            Scanner input = new Scanner(infile);

            String line = "";
            int lineNum = 0;
            while (input.hasNextLine())
            {
                lineNum++;
                line = input.nextLine();
                String [] tokens = line.split(" ");

                String selection = tokens[0];
                int itemName = Integer.parseInt(tokens[1]);

                String message = "at line #" + lineNum + ": " + line;

                // When an item is added:
                // If the item is not in our inventory,
                // create a new entry in our inventory.
                // Otherwise, increment the count of the item.
                if (selection.equals("add"))
                {
                    market.addToInventory(arrayOfSongs[itemName]);

                    // NOTE: Currently displaying the contents is disabled to reduce cluttering the output.
                    // Suggestion: To start, enable displaying the contents of the tree to help you debug.
                    if (SHOW_DETAILS)
                        market.displayInventoryState("\nUpdate " + message, true);
                }

                // When an item is bought:
                // Decrement the count of the item.
                // If the item is out of stock,
                // remove the item from inventory.
                //
                // Note: buying an out of stock item, is invalid. Handle it appropriately.
                else if (selection.equals("buy"))
                {
                    try
                    {
                        market.removeFromInventory(arrayOfSongs[itemName]);

                        // NOTE: Currently displaying the contents is disabled to reduce cluttering the output.
                        // Suggestion: To start, enable displaying the contents of the tree to help you debug.
                        if (SHOW_DETAILS)
                            market.displayInventoryState("\nUpdate " + message, true);
                    }
                    catch (java.util.NoSuchElementException ex)
                    {
                        // NOTE: Ideally we'd print to the error stream,
                        //       but to allow correct interleaving of the output
                        //       we'll use the regular output stream.
                        System.out.printf("\nWarning: Unable to fulfill request: %s \n", message);
                        System.out.printf("Warning: Item %s is out of stock.\n", itemName);
                    }
                }
                else
                {
                    System.out.println("Warning: Inventory selection not recognized!");
                }

                // Display the first item and the last item before checking
                // if it's time to clean up our inventory.
                if (SHOW_DETAILS)
                    market.showFirstAndLastItem(message);
            }


            //testing of searching for specific name of song
            System.out.println("-----------------------------------------------------------");
            System.out.println("\n\n\n\n\n\n");
            System.out.println("The song we want to find is    "+ arrayOfSongs[4]);
            System.out.println("The song we find!   " +market.inventory.find(new song(arrayOfSongs[4])));
            System.out.println("The song we find based on name"+ market.inventory.find("(Don't Fear) The Reaper"));







        input.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {	e.printStackTrace(); }
        catch (ParseException e)
        {	e.printStackTrace(); }




        // Display the inventory
        System.out.println("\n");
        market.displayInventoryState("\nFinal state of inventory:", true);

        // flush the error stream
        System.err.flush();

        System.out.println("\nDone with SuperMarket.");
    }
}
