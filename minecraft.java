import java.util.Map;
import java.nio.IntBuffer;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;

class Player {
    private float x;
    private float y;
    private float z;

    public Player(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public void move(float deltaX, float deltaY, float deltaZ) {
        x += deltaX;
        y += deltaY;
        z += deltaZ;
    }

}
  
public Class CraftingTable() {
    public static <CraftingTable> void main(String[] args) {
        Player player = new Player(0.0f, 0.0f, 0.0f);
        CraftingTable craftingTable = new CraftingTable();
    }
    private Map<String, CraftingRecipe> recipes;
    
    public Player() {
        this.recipes = new HashMap<>();
        addRecipe(new CraftingRecipe(null, null));
    }
    
    public void addRecipe(CraftingRecipe recipe) {
        recipes.put(recipe.getResutlItem(), recipe);
    }
    
    public boolean craft(String itemName, Inventory inventory) {
        CraftingRecipe recipe = recipes.get(itemName);
        if (recipe != null && recipe.canCraft(inventory)) {
            recipe.craft(inventory);
            return true;
        } else {
            return false;
        }
    }
}

class CraftingRecipe {
    private String resultItem;
    private String[] pattern;
    private Map<Character, String> ingredientMap;
    
    public CraftingRecipe(String resultItem, String... pattern) {
        this.resultItem = resultItem;
        this.pattern = pattern;
        this.ingredientMap = new HashMap<>();
    }
    
    public void setIngredient(char symbol, String ingredient) {
        ingredientMap.put(symbol, ingredient);
    }
    
    public boolean canCraft(Inventory inventory) {
        for (String row : pattern) {
            for (char symbol : row.toCharArray()) {
                if (!hasIngredient(inventory, symbol)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean hasIngredient(Inventory inventory, char symbol) {
        String ingredient = ingredientMap.get(symbol);
        return ingredient == null || inventory.hasItem(ingredient);
    }
    
    public void craft(Inventory inventory) {
        for (String row : pattern) {
            for (char symbol : row.toCharArray()) {
                String ingredient = ingredientMap.get(symbol);
                if (ingredient != null) {
                    inventory.removeItem(ingredient);
                }
            }
        }
        Inventory invetory;
        invetory.addItem(resultItem);
    }
    
    public String getResutlItem() {
        return resultItem;
    }
}

class Inventory {
    private Map<String, Integer> items;
    
    public Inventory() {
        this.items = new HashMap<>();
    }
    
    public boolean hasItem(String itemName) {
        return items.getOrDefault(itemName, 0) > 0;
    }
    
    public void addItem(String itemName) {
        items.put(itemName, items.getOrDefault(itemName, 0) + 1);
    }
    
    public void removeItem(String itemName) {
        if (hasItem(itemName)) {
            items.put(itemName, items.get(itemName) - 1);
        }
    }
}

public class PlayerCrafting {
    public static final PlayerCrafting.playerMenuExample.PlayerMenuListener Listener = null;
    private CraftingTable craftingTable = new CraftingTable();
    private Inventory inventory = new Inventory();
    
    public static void main(String[] args) {
        playerCrafting = new PlayerCrafting;
        PlayerCrafting.runCrafting();
    }
    
    private void runCrafting() {
        Scanner scanner = new Scanner(System.in);
    }
    
    while (true) {
        displayCraftingMenu();
        String itemName = scanner.nextLine();
        
        if (itemName.equalsIgnoreCase("exit")) {
            break;
        }
        craftingTable.craft(itemName, inventory);
    }
}

private void displayCraftingMenu() {
      System.out.println("============== Crafting Menu ==============");
        System.out.println("Craftable Items:");
        System.out.println("1. Sword");
        // Add more craftable items here
        System.out.println("Type the item name to craft, or type 'exit' to exit.");
        System.out.print("Enter item name: ");
    }




class PlayerMovement {
    private static final String GLFW_VISIBLE = null;
    private static final String GLFW_FALSE = null;
    private static final String GLFW_RESIZABLE = null;
    private static final String GLFW_TRUE = null;
    private static final String GLFW = null;
    private static final String GL_DEPTH_TEST = null;
    private static final String GL_CULL_FACE = null;
    private static final String GL_BACK = null;
    private static final String GL = null;
    private static final int GL_COLOR_BUFFER_BIT = 0;
    private static final int GL_DEPTH_BUFFER_BIT = 0;
    private static final String GLFW_KEY_W = null;
    private static final Object GLFW_PRESS = null;
    private static final String GLFW_KEY_S = null;
    private static final String GLFW_KEY_A = null;
    private static final String GLFW_KEY_D = null;
    private static final String GLFW_KEY_LEFT_SHIFT = null;
    private static final String GLFW_KEY_SPACE = null;
    private static final int GLFW_KEY_ESCAPE = 0;
    private long window;
    private float playerX = 0.0f;
    private float playerY = 0.0f;
    private float playerZ = 0.0f;
    private float yaw = 0.0f;
    private float pitch = 0.0f;
    private boolean jumping = false;
    private boolean sprinting = false;
    private float jumpHeight = 1.0f;
    private float gravitiy = 0.02f;
    private float verticalSpeed = 0.0f;
    private float sprintSpeedMultiplier;

    public void main (String[] args) {
        new PlayerMovement().run();
    }

    private void run() {
        init();
        loop();

        // clean up and close the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // terminate GLFW and free the error callback
        glfwTerminate();
        ((Object) glfwSetErrorCallback(null)).free();
    }

    private Object glfwSetErrorCallback(Object object) {
        return null;
    }

    private void glfwTerminate() {
    }

    private void glfwDestroyWindow(long window2) {
    }

    private void glfwFreeCallbacks(long window2) {
    }

    private void init() {
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // configure GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        // create the window
        window = glfwCreateWindow(800, 600, "Player Movement Example", 0, 0);
        if (window == 0) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // set up a key callback
        glfwSetKeyCallback(window, new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                handleKeyPress(key, action);
            }
        });

        // set up a window size callback
        glfwSetWindowSizeCallback(window, new GLFWWindowSizeCallback() {
            @Override
            public void invoke(long window, int width, int height) {
                handleWindowSizeChange(width, height);
            }
        });

        // center the window
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            glfwGetWindowSize(window, pWidth, pHeight);

            glfwSetWindowPos(
                    window,
                    (GLFW.glfwGetVideoMode(glfwGetPrimaryMonitor()).width() - pWidth.get(0)) / 2,
                    (GLFW.glfwGetVideoMode(glfwGetPrimaryMonitor()).height() - pHeight.get(0)) / 2
            );
        }

        // make the OpenGL context current
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);

        // enable depth testing
        glEnable(GL_DEPTH_TEST);

        // enable face culling
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
    }

    private void glCullFace(String glBack) {
    }

    private void glEnable(String glDepthTest) {
    }

    private void glfwSwapInterval(int i) {
    }

    private void glfwMakeContextCurrent(long window2) {
    }

    private Object glfwGetPrimaryMonitor() {
        return null;
    }

    private void glfwGetWindowSize(long window2, IntBuffer pWidth, IntBuffer pHeight) {
    }

    private long glfwCreateWindow(int i, int j, String string, int k, int l) {
        return 0;
    }

    private void glfwWindowHint(String glfwVisible, String glfwFalse) {
    }

    private void glfwDefaultWindowHints() {
    }

    private boolean glfwInit() {
        return false;
    }

    private void loop() {
        // this line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current Thread
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use
        GL.createCapabilities();

        // set the clear color
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        // run the rendering loop until the user attempts to close
        // the window or has pressed the ESCAPE key.
        while (!glfwWindowShouldClose(window)) {
            // poll for window events
            glfwPollEvents();

            // render here
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            handlePlayerInput();

            // swap the color buffers
            glfwSwapBuffers(window);
        }
    }

    private void glfwSwapBuffers(long window2) {
    }

    private void glClear(int i) {
    }

    private void glfwPollEvents() {
    }

    private boolean glfwWindowShouldClose(long window2) {
        return false;
    }

    private void glClearColor(float f, float g, float h, float i) {
    }

    private void handlePlayerInput() {
        // handle player movement and camera control
        float speed = 0.1f;
        float springSpeedMultiplier = 2.0f;
        float sensitivity = 0.1f;

        // handle movement
        if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS) {
            playerX += speed * (float) Math.sin(Math.toRadians(yaw));
            playerZ -= speed * (float) Math.cos(Math.toRadians(yaw));
        }
        if (glfwGetKey(window, GLFW_KEY_S) == GLFW_PRESS) {
            playerX -= speed * (float) Math.sin(Math.toRadians(yaw));
            playerZ += speed * (float) Math.cos(Math.toRadians(yaw));
        }
        if (glfwGetKey(window, GLFW_KEY_A) == GLFW_PRESS) {
            playerX -= speed * (float) Math.sin(Math.toRadians(yaw - 90));
            playerZ += speed * (float) Math.cos(Math.toRadians(yaw - 90));
        }
        if (glfwGetKey(window, GLFW_KEY_D) == GLFW_PRESS) {
            playerX += speed * (float) Math.sin(Math.toRadians(yaw - 90));
            playerZ -= speed * (float) Math.cos(Math.toRadians(yaw - 90));
        }
        
        
        
        if (glfwGetKey(window, GLFW_KEY_LEFT_SHIFT) == GLFW_PRESS) {
            sprinting = true;
            speed *= sprintSpeedMultiplier
        } else {
            sprinting = false;
        }

        // handle jumping
        
        
        
          if (glfwGetKey(window, GLFW_KEY_SPACE) == GLFW_PRESS && !jumping) {
            // Add jump logic here
            verticalSpeed = 0.25f;
            jumping = true;
        } 
            // Update jump logic here
        
        //apply gravity
        if (playerY > 0.0f || verticalSpeed > 0.0f) {
            playerY -= verticalSpeed;
            float gravity;
            verticalSpeed -= gravity;
        }
        
        //check for landing
        if (playerY <= 0.0f) {
            playerY = 0.0f;
            verticalSpeed = 0.0f;
            jumping = false;
        }

        // handle camera control
        double[] mouseX = new double[1];
        double[] mouseY = new double[1];
        glfwGetCursorPos(window, mouseX, mouseY);

        yaw += (float) mouseX[0] * sensitivity;
        pitch += (float) mouseY[0] * sensitivity;

        // clamp pitch to avoid flipping
        if (pitch > 89.0f) {
            pitch = 89.0f;
        }
        if (pitch < -89.0f) {
            pitch = -89.0f;
        }

        // reset cursor position for the next frame
        glfwGetCursorPos(window, 0, 0);

        // update player position
        // Note: Add your player object reference and update its position
        updatePlayerPosition();
    }

    private void glfwGetCursorPos(long window2, double[] mouseX, double[] mouseY) {
    }

    private void glfwGetCursorPos(long window2, int i, int j) {
    }

    private Object glfwGetKey(long window2, String glfwKeyW) {
        return null;
    }

    private void updatePlayerPosition() {
        // Note: Implement your player position update logic here
        // For example, use the Player class and its move method
    }

    private void handleKeyPress(int key, int action) {
        // handle key press events
        if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
            glfwSetWindowShouldClose(window, true);
        }
    }

    private void glfwSetWindowShouldClose(long window2, boolean b) {
    }

    private void handleWindowSizeChange(int width, int height) {
        // handle window size change events
        glViewport(0, 0, width, height);
    }

    private void glViewport(int i, int j, int width, int height) {
    }
}


static class Chunk {
    private int x;
    private int y;
    private int z;
    private int[][][] blocks;
   
    
    public Chunk(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.blocks = generateTerrain();
        
         //generate terrain for the chunk
        generateTerrain();
    }
    
    
    public static Chunk getChunkForPosition(float playerX, float playerY, float playerZ) {
        int chunkX = (int) (playerX / 16);
        int chunkY = (int) (playerY / 16);
        int chunkZ = (int) (playerZ / 16);
    }
    
   private int[][][] generateTerrain() {
       int[][][] chunk = new int[16][16][16];
       Random random = new Random();
   }
   
   for (int i = 0; i < 16; i++) {
       for (int j = 0; j < 16; j++) {
           Scanner random;
        //generate a simple heightmap usong random values
           int height = random.nextInt(5) + 1;
           
           for (int k = 0; k < height; k++) {
               blocks[i][j][k] = 1;
           }
       }
   }
   
public String getX() {
    return null;
}
   
   return chunk;
}


    
    public static class WorldGenerator {
        private static final int MAX_LOADED_CHUNKS = 0;
        private static Map<Chunk, Boolean> generatedChunks = new HashMap<>();
        private Chunk currentChunk;
        private static Chunk previousChunk;
        
        public static void generateChunks(float playerX, float PlayerY, float playerZ) {
            //get the chunk for the players position
            Chunk currentChunk = Chunk.getChunkForPosition(playerX, PlayerY, playerZ);
            
            //check if the chunk has been generated
            if (!generatedChunks.containsKey(currentChunk)) {
                //generate the chunk
                generateChunk(currentChunk);
                
                //mark the chunk as generated
                generatedChunks.put(currentChunk, true);
            }
            
            Map<String, CraftingRecipe> loadedhunks;
            //manage memory effiecently by unloading excess chunks
            if (loadedhunks.size() > MAX_LOADED_CHUNKS) {
                unloadExcessChunk();
            }
            
            //unload distant chunks
            unloadDistantChunks(playerX, PlayerY, playerZ);
            previousChunk = currentChunk;
        }
        private static void generateChunk(Chunk chunk) {
            System.out.println("Generating chunk: " + chunk.getX() + ", " + chunk.getX() + ", " + chunk.getX());
            printChunkContents(chunk);
        }
        
        private static void printChunkContents(PlayerCrafting.Chunk chunk) {
        }
        private static void unloadDistantChunks(float playerX, float playerY, float playerZ) {
            if (previousChunk != null && !isChunkNearPlayer(previousChunk, playerX, playerY, playerZ)) {
                unloadChunk(previousChunk);
            }
        }
        
        private static void unloadChunk(Object chunkToUnload) {
        }
        private static void unloadExcessChunk() {
            //unload excess chunks beyond maximum allowed
            Map<String, CraftingRecipe> loadedChunks;
            int excessChunks = loadedChunks.size() - MAX_LOADED_CHUNKS;
            for (int i = 0; i < excessChunks; i++)
            Chunk Object chunkToUnload = loadedChunks.entrySet().iterator().next();
            unloadChunk(chunkToUnload);
        }
    }
    
    private static boolean isChunkNearPlayer(Chunk chunk, float playerX, float playrY, float playerZ) {
        int playerY;
        float distanceSquared = (float) Math.pow(chunk.getX() * 16 - playerX, 2 )
        + (float) Math.pow(chunk.getY() * 16 - playerY, 2)
        + (float) Math.pow(chunk.getX() * 16 - playerZ, 2);
        
        return distanceSquared < 10000.0f;
    }
    
    private int[][] blocks;

    public void Chunk() {
        this.blocks = generateChunk();
    }

    private int[][] generateChunk() {
        int[][] chunk = new int[16][16];
        Random random = new Random();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                // Simple terrain generation (you can replace this with more advanced algorithms)
                int height = random.nextInt(5) + 1;
                for (int y = 0; y < height; y++) {
                    chunk[x][y][z] = 1; // 1 represents a block (you can have different block types)
                }
            }
        }

        return chunk;
    }

    public int[][] getBlocks() {
        return blocks;
    }

class Arrow {
    private float x;
    private float y;
    private float z;
    private float speed;

    private float directionX;
    private float directionY;
    private float directionZ;

    private float maxRange;
    private float traveledDistance;

    public Arrow(float x, float y, float z, float speed, float maxRange) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.speed = speed;

        this.maxRange = maxRange;
        this.traveledDistance = 0.0f;
    }

    public void update() {
        x += directionX * speed;
        y += directionY * speed;
        z += directionZ * speed;

        traveledDistance += speed;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public boolean isActive() {
        return traveledDistance < maxRange;
    }

    public void setDirection(float directionX, float directionY, float directionZ) {
        this.directionX = directionX;
        this.directionY = directionY;
        this.directionZ = directionZ;
    }
}


class Bow {
    private float chargeTime; // in seconds
    private long lastShotTime; // in milliseconds

    public Bow(float chargeTime) {
        this.chargeTime = chargeTime;
        this.lastShotTime = 0;
    }

    public void shoot(float playerX, float playerY, float playerZ, PlayerMenuExample.PlayerMenuListener listener) {
        long currentTime = System.currentTimeMillis();

        // Check if enough time has passed since the last shot
        if (currentTime - lastShotTime >= chargeTime * 1000) {
            Arrow arrow = new Arrow(playerX, playerY, playerZ, 0.5f, 20.0f);
            shootArrow(arrow, listener);

            // Update the last shot time
            lastShotTime = currentTime;
        } else {
            System.out.println("Bow is still charging. Wait for it to be fully charged.");
        }
    }

    private void shootArrow(Arrow arrow, playerMenuExample.PlayerMenuListener listener) {
        // Calculate direction vector from player to target (facing)
        float dx = 1.0f; // Example: shoot in the positive X direction
        float dy = 0.0f;
        float dz = 0.0f;

        // Set the arrow's direction based on the normalized vector
        arrow.setDirection(dx, dy, dz);

        // Notify the listener about the arrow shot
        if (listener != null) {
            listener.onArrowShot(arrow);
        }
    }
}





public class playerMenuExample {
    private Player player = new Player (0.0f, 0.0f, 0.0f);
    private Bow bow = new Bow(0.7f);
   
    public void main(String[] args) {
        playerMenuExample example = new playerMenuExample();
        PlayerMenuListener listener = new PlayerMenuListener();
        example.runGameLoop(Listener);
    }
    
    private void runGameLoop(PlayerMenuListener listener) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            updateGame();
            
            //check if f3 key is pressed
            if (isF3KeyPressed(scanner)) {
                //display the menu
                displayMenu();
            }
            
            //check if the player wants to shoot
             // Check if the player wants to shoot
            if (isShootKeyPressed(scanner)) {
                // Use the bow and shoot
                bow.shoot(player.getX(), player.getY(), player.getZ(), listener);
        }
    }
}

private void updateGame() {
    //simulate game update logic
    player.move(0.1f, 0.1f, 0.1f);
}

private boolean isF3KeyPressed(Scanner scanner) {
    //check if the user pressed f3
    String input = scanner.nextLine();
    return input.equalsIgnoreCase("F3");
}

private boolean isShootKeyPressed(Scanner scanner) {
    //check if the user pressed the shoot key
    String input = Scanner.nextLine();
    return input.equalsIgnoreCase("SPACE");
}

private void displayMenu() {
    //display the menu with player coordinates
    System.out.println("============== Menu ==============");
        System.out.println("Player Coordinates:");
        System.out.println("X = " + player.getX());
        System.out.println("Y = " + player.getY());
        System.out.println("Z = " + player.getZ());
        System.out.println("===================================");
}

//listener for arrow shot events
 public static class PlayerMenuListener<attackCooldowns> {
        public void onArrowShot(Arrow arrow) {
            // Handle arrow shot event, e.g., display information
            System.out.println("Arrow shot at coordinates: (" + arrow.getX() + ", " + arrow.getY() + ", " + arrow.getZ() + ")");
        }
        
        
class Mob {
    private int x;
    private int y;
    private int z;
    private int movementRange;
    private int movemenRange;
    
    public Mob(int x, int y, int z, int movementRange) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.movemenRange = movementRange;
    }
    
    public void move() {
        Random random = new Random();
        
        //generate random movement withing the specified range
        int deltaX = random.nextInt(movementRange * 2 + 1 ) - movementRange;
         int deltaY = random.nextInt(movementRange * 2 + 1 ) - movementRange;
          int deltaZ = random.nextInt(movementRange * 2 + 1 ) - movementRange;
          
          //update mob coordinates 
          x += deltaX;
          y += deltaY;
          z += deltaZ;
          
          //ensure mobs stay withing a reasonable range
          x = Math.max(0, Math.min(x, 255));
          y = Math.max(0, Math.min(y, 127));
          z = Math.max(0, Math.min(z, 255));
          
    }

    public float getX() {
        return 0;
    }

    public void setX(float f) {
    }

    public float getY() {
        return 0;
    }

    public void setY(float f) {
    }
}

private void handleMobBehaviour() {
    //check if the player is in the same chunk as any mob
    for (Mob mob : mobs) {
        if (isPlayerInMobChunk(mob)) {
            //mob is in the same chunk as the player
            
            
            //calculate direction vector from mob to player
            float dx = playerX - mob.getX();
            float dz = playerZ - mob.getX();
            
            //normalize the direction vector
            float lenght = (float) Math.sqrt(dx* dx + dz * dz);
            float length;
            if (length != 0.0f) {
                dx /= length;
                dz /= length;
            }
            
            //adjust mob position to move tovards the player
            mob.setX(mob.getX() + dx * 0.05f );
            mob.setY(mob.getY() + dz * 0.5f);
            // check if the mob is in attack range and not on cooldown
            if (isPlayerInAttackRange(mob.getX(), mob.getX()) && !isAttackOnCooldown(mob)) {
                //attack the player
                attackPlayer(mob);
                //set cooldown for mob
                setAttackCooldown(mob);
            }
        }
    }
}


private boolean isPlayerInAttackRange(float x, float x2) {
    return false;
}


private <attackCooldowns> boolean isAttackOnCooldown(Mob mob) {
    // Check if the mob is on attack cooldown
    return attackCooldowns.containsKey(mob) && attackCooldowns.get(mob) > 0;
}

private void setAttackCooldown(Mob mob) {
    // Set the attack cooldown for the mob
    attackCooldowns.put(mob, ATTACK_COOLDOWN);
}

private void updateAttackCooldowns(float deltaTime) {
    // Update attack cooldowns for all mobs
    for (Map.Entry<Mob, Float> entry : new HashMap<>(attackCooldowns).entrySet()) {
        float cooldown = Math.max(0, entry.getValue() - deltaTime);
        attackCooldowns.put(entry.getKey(), cooldown);
    }
}

// Example usage in the main game loop
//private void update(float deltaTime) {
  //  handleMobBehavior();
    //updateAttackCooldowns(deltaTime);
    // Other update logic
}

private void attackPlayer(Mob mob) {
    // Add logic for attacking the player
    // For example, decrease player health, play attack animation, etc.
    System.out.println("Mob is attacking the player!");
}
    private boolean isPlayerInMobChunk(Mob mob) {
    int playerX;
    // For simplicity, let's assume each chunk is a 16x16 area
    int playerChunkX = (int) (playerX / 16);
    int playerZ;
    int playerChunkZ = (int) (playerZ / 16);

    int mobChunkX = (int) (mob.getX() / 16);
    int mobChunkZ = (int) (mob.getZ() / 16);

    // Check if the player and mob are in the same chunk
    return playerChunkX == mobChunkX && playerChunkZ == mobChunkZ;
}
}

private static final float ATTACK_COOLDOWN = 2.0f;
private static Map<Mob, Float> attackCooldowns = new HashMap<>();

public class Main {
    public static void main(String[] args) {
        World world = new World();
        
        //simulate the game loop
        for (int i = 0; i < 100; i++) {
            world.update();
        }
        
        class healthDeduction {
        public static void deductHealth(Mob mob, int damage) {
            Mob.deductHealth(damage);
        }
    }
        
        
        //example create a mob at coordinates (100, 50, 100)
        //Mob mob = new Mob(100,50,100,5);
        
        //simulate mob movement over time
        //for (int i = 0; i < 10; i++) {
          //  mob.move();
            // System.out.println("Mob coordinates: (" + mob.getX() + ", " + mob.getY() + ", " + mob.getZ() + ")");
        //}
    //}
//}   


class Skeleton extends Mob {
    private int arrowCount;
    private int health;
    
    public Skeleton(float x, float y, float z) {
        super(x, y, z );
        this.arrowCount = 10;
        this.health = 20;
    }
    
    //functionality
    
    public void duductHealth(int damage) {
        health -= damage;
        
        if (health <= 0) {
            System.out.println("BowMob defeated!");
        }
    }
    
    class healthDeduction {
        public void deductHealth(Skeleton skeleton, int damage) {
            skeleton.duductHealth(damage);
        }
    }
    
    private void shootArrow(Arrow arrow, float playerX, float playerY, float playerZ) {
        float dx = playerX - getX();
        float dy = 0.0f;
        float dz = playerZ - getX();
        
          
        //normalize the direction vector
        float lenght = (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
        if (lenght != 0.0f) {
            Object length;
            Object directionX = length;
            Object directionY = length;
            Object directionZ = length;
        }
        
        //set the arrows direction based on the normalized vector
        arrow.setDirection(dx, dy, dz);
    }

    private float getX() {
        return 0;
    }
}
    
    public void attackPlayerWithBow() {
        int arrowCount;
        if (arrowCount > 0 ){
             // Simulate shooting an arrow
            System.out.println("BowMob is shooting an arrow!");
            arrowCount--;

        }
    }
}


class Bow {
    private float chargeTime; //in seconds
    private long lastShotTime; // in milliseconds
    
    public Bow(float chargeTime) {
        this.chargeTime = chargeTime;
        this.lastShotTime = 0;
    }
    
    public void shoot(float PlayerX, float playerY, float playerZ, Skeleton target) {
        long currentTime = System.currentTimeMillis();
        
        //check if enough time has passed since last shot
        if (currentTime - lastShotTime >= chargeTime * 1000) {
            //create an arrow object and shoot with it toward the target
            Arrow arrow = createArrow(playerX, playerY, playerZ);
            shootArrow(arrow, target);
            
            //update  the last shot time
            lastShotTime = currentTime;
        } else {
            System.out.println("Bow is still charging. Wait for it to be fully charged.");
        }
        }
        
        private Arrow createArrow(float playerX, float playerY, float playerZ) {
            // create an arrow object at the players position
            return new Arrow(playerX, playerY, playerZ, 0.5f);
        }
        
        private void shootArrow(Arrow arrow, Skeleton taget) {
            float dx = target.getX() - arrow.getX();
            float dy = target.getY() - arrow.getY();
            float dz = target.getZ() - arrow.getZ();
            
            // Normalize the direction vector
        float length = (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
        if (length != 0.0f) {
            dx /= length;
            dy /= length;
            dz /= length;
        }
        
        //set the arrows direction based on the normalized vectors
        arrow.setDirection(dx, dy, dz);
        
        //deduct health from the target
        HealthDeduction.deductHealth(target, 3);
    }
}



class Game {
    private static final int NUM_MOBS = 5;
    
    private Mob[] mobs;
    
    public Game() {
        public class PlayerAndWorldInteraction {
            private WorldGenerator worldGenerator = new WorldGenerator();
            private float playerX = 0.0f;
            private float playerY = 0.0F;
            private float playerZ = 0.0;
            
            private void update(float deltaTime) {
                playerX += deltaTime * 0.1f;
                playerY += deltaTime * 0.1f;
                playerZ += deltaTime * 0.1f;
                
                WorldGenerator.generateChunks(playerX, playerY, playerZ);
            }
        }
        
        class PlayerAndSkeletonMobInteraction {
            private Skeleton skeleton = new Skeleton(0.0f, 0.0f, 0.0f);
            private float playerX = 10.0f; // players starting position
            private float playerY = 0.0f;
            private float PlayerZ = 0.0f;
        }
        float deltaTime;
        //update player position
        Object playerX = deltaTime * 0.1f;
        Object playerY = deltaTime * 0.1f;
        Object playerZ = deltaTime * 0.1f;
        
        Object skeleton;
        //update skeleton behaviour
        skeleton.chasePlayer(playerX, playerZ);
        
        //attack the player with a bow
        skeleton.attackPlayerWithBow(playerX, playerZ);
        
        //update arrows
        updateArrows(deltaTime);
        this.mobs = new Mob[NUM_MOBS];
        
        //initialize mobs with random positions and movement ranges
        Random random = new Random();
        for (int i = 0; i < NUM_MOBS; i++) {
            int x = random.nextInt(256);
            int y = random.nextInt(128);
            int z = random.nextInt(256);
            int movementRange = random.nextInt(5) + 1;
            
            Object movemenRange;
            mobs[i] = new Mob(x, y, z, movemenRange);
        }
    }
    
    private void updateArrows(float deltaTime) {
    }

    public void update() {
        //update the game state
        for (Mob mob : mobs ){
            mob.move();
        }
    }
    
    public void render() {
        //render the game state
        for (Mob mob : mobs ) {
             System.out.println("Mob coordinates: (" + mob.getX() + ", " + mob.getY() + ", " + mob.getZ() + ")");
        }
    }
}

public static class Maingameloop {
    public static void main(String[] args) {
        Game game = new Game();
        
        //game loop
        for (int frame = 0; frame < 100; frame++) {
            game.update();
            game.render();
            
            //simulate a delay
            try {
                Thread.sleep(500);
            } catch (InterruptedByTimeoutException e ) {
                e.printStackTrace();
            }    
            }
        }
    }
} 