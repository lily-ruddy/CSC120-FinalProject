# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 - What **new thing(s)** did you learn / figure out in completing this project?
 - Is there anything that you wish you had **implemented differently**?
 - If you had **unlimited time**, what additional features would you implement?
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

My overall approach was to get the main gameplay loop up and running and then build off of that. I really wanted to set up a solid foundation where I was able to really easily build upon it. So, I first started working on a Main.java file where I wanted to keep everything organized. Then as I approached certain obstacles I created classes to help solve those problems. 

I've learned a lot about how to put the things we've learned in class and implement it to create a fully functional game. The game is far from done, but being able to weave together all the concepts we've learned in this class is a big achievement. 

Overall I'm pretty happy with the way I coded things. I think there are definite areas of improvement, but I attempted to reduce the amount of repeated code. I tried to make my code more generalized like in the main bedroom. However, I failed to do so in the hallway. For each different colored door I have essentially the same code repeated, which was something I tried to avoid. If I had more time I would definitely make my code more efficient and expand upon the tower. I wanted to implement more of the game play action but didn't have enough time to do so. 

I think the most helpful piece of feedback was to start off with a Room or Person class. I really struggled with starting this final project since it functions so differently compared to the homeworks we've done previously. I think I've been spoiled with the detailed instructions in the homeworks that I was lost on how to begin. Once I started off with creating a Room class I was able to be more productive. 

I think if I was able to go back in time to my past self, I would say don't get caught up in the small details and focus on the big picture. I was pretty disappointed that I was unable to make more progress on the game. I wasn't able to have an ending to my game or have a way to use the items that the user has collected. 

For navigation through my game, I could have used Graphs to help build my map. It would have been more immersive and had better functionality. Instead, I just had a room parameter for the user that updated depending on its location. I didn't switch to using graphs because I was far enough along in my project that it wasn't worth it to pivot. If I had more time, I would have loved to explore the usage of graphs in my game. 