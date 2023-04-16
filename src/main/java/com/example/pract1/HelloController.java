package com.example.pract1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class HelloController {
    @FXML
    private Text Welcometext;
    @FXML
    private Text Error;
    @FXML
    private Text AppName;
    @FXML
    private Text Instruction;
    @FXML
    private Text Result;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SubmitButton;
    @FXML
    private TextField xName;
    @FXML
    private DatePicker xDOB;
    @FXML
    private Text ResultOnName;
    @FXML
    private Text ResultOnDay;

    public void CancelButtonOnAction(ActionEvent e){
        //close Application
        Stage stage =  (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }
    public void SubmitButtonOnAction(ActionEvent e){
       //Validation of Inputs
        if(xName.getText().isBlank() == true ){
            Error.setText("Input your name!!");
        }
        if( xDOB.getValue() == null){
            Error.setText("Enter DoB!!");
        }
        if( xDOB.getValue() == null && xName.getText().isBlank() == true ){
            Error.setText("All fields are required!!");
        } else if (xDOB.getValue() != null && xName.getText().isBlank() != true ) {
            Error.setText("Thankyou ;)");
        }

        //Get Name and DOB
        String Name = xName.getText();
        LocalDate DOB = xDOB.getValue();

        //single digit DOB
        int luckyNumber=0;
        String yDOB = DOB.toString();
        for(int i=0; i<yDOB.length();i++){
            if(yDOB.charAt(i) != '-'){
                luckyNumber = luckyNumber +Integer.parseInt(String.valueOf(yDOB.charAt(i)));
            }
        }
        luckyNumber = sumOfDigits(luckyNumber);

        //Day of Birth Calculation
        LocalDate date = LocalDate.parse(yDOB);
        DayOfWeek dayOfBirth = date.getDayOfWeek();

        //First digit of Name
        char firstDigit = Name.charAt(0);

        //Greeting
        Welcometext.setText(" Hello " + Name + ",");

        //Call methods
        ResultOfDOB(luckyNumber,yDOB);
        ResultOfName(firstDigit);
        ResultOfDay(dayOfBirth.name());
    }

    public void ResultOfDOB(int LuckyNumber,String zDoB) {

        switch (LuckyNumber) {
            case 1:
                Result.setText("Results based on DoB " + zDoB +":\n"+ "Your Lucky number is: 1 \n" +
                        "Your friend number is: 1,2,4,5,7,9 \n" +
                        "Your neutral number is: 3 \n" +
                        "Your enemy number is: 6,8 \n" +
                        "Just as Aries, the first sign of the zodiac, is about action and initiation, in numerology, 1 is linked to forward motion. 1 symbolizes a pioneering spirit, independent nature, and innate leadership capabilities. On a bad day, 1 can be a bit bossy or boastful, hiding any insecurities behind over-developed self-importance. 1 must remember that although it is first, it can very quickly become the loneliest number. Even the most autonomous 1s need the support of their friends, family, and lovers.\n");
                break;
            case 2:
                Result.setText("Results based on DoB " + zDoB +":\n"+ "Your Lucky number is: 2 \n" +
                        "Your friend number is: 1,2,4,3,7,8 \n" +
                        "Your neutral number is: 5,6 \n" +
                        "Your enemy number is: 9 2 \n" +
                        "It is linked to sensitivity, balance, and harmony. Within numerology, the 2 vibration assumes the role of the mediator, creating harmony by bringing together dissonant forces through compassion, empathy, and kindness. 2 is linked to psychic abilities and intuition,and if this number appears as a Life Path or Destiny Number, the individual will be astute to subtle energy shifts and emotional nuances. Because 2 is so sensitive, it is very conflict-averse, and can end up feeling under-appreciated or unacknowledged.\n");
                break;
            case 3:
                Result.setText("Results based on DoB " + zDoB +":\n"+ "Your Lucky number is: 3 \n" +
                        "Your friend number is: 2,3,6,8,9 \n" +
                        "Your neutral number is: 1,4,7 \n" +
                        "Your enemy number is: 5 \n" +
                        "Communication is paramount for 3. Symbolically, 3 represents the output of two joined forces: It is the essence of creation. 3 is highly gifted at expression, seamlessly sharing innovative and pioneering concepts through art, writing, and oration. Your work inspires, motivates, and uplifts others, and 3 finds great joy making others smile. However, 3 is also known to be quite moody, and if 3 feels misunderstood, may withdraw entirely. The escapist tendencies of 3 are easily mitigated by practicing peaceful mindfulness. \n");
                break;
            case 4:
                Result.setText("Results based on DOB " + zDoB +":\n"+ " Lucky number is: 4 \n" +
                        "Your friend number is: 1,2,4,5,7 \n" +
                        "Your neutral number is: 3,8,9 \n" +
                        "Your enemy number is: 6,8 \n" +
                        "In numerology, 4 has an earthy-energy and is centered around fortifying its roots. 4 adamantly believes in the physical world and knows that investing in a solid infrastructure is necessary for building a lasting legacy. Practical, hardworking, and responsible, the vibration of the number 4 is focused on creating logical systems that can support scalable growth. There is a solidity to 4, however, that can quickly devolve into rigidity; 4 must remember that rules are meant to enhance, not inhibit. Its easy for 4 to become stubborn.\n");
                break;
            case 5:
                Result.setText("Results based on DOB " + zDoB +":\n"+ " Lucky number is: 5 \n" +
                        "Your friend number is: 1,4,5 \n" +
                        "Your neutral number is: 2,3,6,7 \n" +
                        "Your enemy number is: 9,8 \n" +
                        "Free-thinking, adventurous, and progressive, 5 is defined by freedom. 5 needs to experience the world by engaging its five senses: For 5, life lessons are acquired through spontaneous acts of bravery. Akin to Sagittarius energy within astrology, 5 is known for its playful, impulsive, and vivacious spirit.But on the other side of its signature joie de vivre, 5 can become restless and impatient. Since 5 is always seeking discovery, it has a difficult time accepting lifes day-to-day responsibilities  including professional and interpersonal commitments.\n");
                break;
            case 6:
                Result.setText("Results based on DOB " + zDoB +":\n"+ " Lucky number is: 6 \n" +
                        "Your friend number is: 3,6,9 \n" +
                        "Your neutral number is: 2,4,5,7,8 \n" +
                        "Your enemy number is: 1 6 \n" +
                        "It is recognized for its nurturing, supportive, and empathic nature. A true healer, 6 has the ability to problem solve in both the emotional and physical realms, helping others through its straightforward, yet gentle, approach. 6 has a strong sense of responsibility, and cares deeply for its friends, family, and lovers. This number also can easily communicate with children and animals, displaying a soft tenderness and caretaker spirit.But not everything needs to be parented, and sometimes 6s protective energy can become domineering and controlling.Simply put, everyone must follow their own unique path. \n");
                break;
            case 7:
                Result.setText("Results based on DOB " + zDoB +":\n"+ " Lucky number is: 7 \n" +
                        "Your friend number is: 1,3,5,6,7,8 \n" +
                        "Your neutral number is: 2,4 \n" +
                        "Your enemy number is: 9 \n" +
                        "The detectives of numerology, 7 is known for its investigative abilities and analytical skills. Astrologically, the number 7 can be thought of as a blend of Virgo and Scorpio energy: 7 is extremely detail-oriented, but is driven by inner-wisdom as opposed to tangible realities. 7 has a keen eye, and its astute observations fuel a quick-witted, inventive spirit. Because it can quickly find the flaws in almost any system, 7 is a bit of a perfectionist.  7 will often assume fault, so its important for this number to counterbalance its inherent skepticism with an open mind.\n");
                break;
            case 8:
                Result.setText("Results based on DOB " + zDoB +":\n"+ " Lucky number is: 8 \n" +
                        "Your friend number is: 3,8 \n" +
                        "Your neutral number is: 2,4,5,6,7,9 \n" +
                        "Your enemy number is: 1 8 \n" +
                        "It is all about abundance. Within numerology, this number is linked to material wealth and financial success. Ambitious and goal-oriented, 8 can effortlessly assume leadership positions through its natural magnetism. 8 applies big-picture thinking to broaden its scope,racing up the top of any ladder to reach extraordinary heights. But with great power comes great responsibility: 8 breeds workaholics, and on a bad day, can become excessively controlling and possessive. However, its negative qualities can be lessened by giving back to the community. \n");
                break;
            case 9:
                Result.setText("Results based on DOB " + zDoB +":\n"+ " Lucky number is: 9 \n" +
                        "Your friend number is: 3,8,9 \n" +
                        "Your neutral number is: 1,4,6,7 \n" +
                        "Your enemy number is: 2,9,8 \n" +
                        "As the final single digit within numerology, 9 connotes an old soul. 9 is no stranger lifes ups-and-downs of life been there, done that. Accordingly, 9 can effortlessly synthesize large quantities of stimuli, psychically connecting the dots to form a cohesive whole. The mission for 9 is to reach its highest state of consciousness, and to help others also achieve this spiritual awareness. 9 isnt afraid to transform, and its malleable spirit inspires others to explore their own ranges of motion. Since 9, in many ways, has transcended the physical plane, it must constantly remember to anchor itself.\n");
                break;

        }
    }

    public void ResultOfName(char fDigit) {
        char chUpper = Character.toUpperCase(fDigit);
        switch (chUpper) {
            case 'A':
                ResultOnName.setText("Results based on " + chUpper +"\n" +
                        "People with the starting letter A in their name are considered to be very purposeful in life and have big ambitions, according to name numerology. Usually the independent type, the goal is everything to them and will do everything to get their dreams fulfilled. Everything they do is original, which is usually what makes them recognized by everyone.\n" +

                        "They can also be quite straightforward and can unintentionally hurt your feelings. Being bold and courageous, they do not just think and contemplate but will act and take steps forward, to reach their destination. Although, their personality can be a bit rigid, as they find it difficult to change or adapt according to situations.");
                break;
            case 'B':
                ResultOnName.setText("Results based on " + chUpper +"\n"+
                        "People with the starting letter B in their name are the sentimental and emotional type. Being reserved and calm in nature, they will always try to maintain harmony everywhere they go. To know what they actually mean when they say or do something is not very difficult as they are quite transparent and open about their feelings.\n" +

                        "But their fixed way of thinking, that what they do or know is usually right is a bit challenging for people associating with them. It can also be a nuisance for them as they lose opportunities when they do not change their way of thinking sometimes.");
                break;
            case 'C':
                ResultOnName.setText("Results based on "+ chUpper +"\n"+
                        "People with the starting alphabet C in their name are the open and expressive ones. As per name numerology, they will not hesitate to share their deepest and darkest secrets and will express them with such seriousness that there will not be a chance to think they are joking. Whatever emotions they feel, they feel them more than anyone else\n" +

                        "Neither do they feel depressed nor would they allow any to feel the same because they do not bottle up their feelings. This makes others around them comfortable doing the same. But in the efforts of trying everything, they can stick to one thought, which makes them lack stability.\n");
                break;
            case 'D':
                ResultOnName.setText("Results based on "+ chUpper +"\n"+
                        "People with the starting letter D in their name are the logical ones of the group. Spontaneity is not their thing as they like to analyze and calculate every movement and step. Because of their methodical manners, they rarely commit any mistakes which in turn gives them the results they desire. Their determination and dedication give them self-confidence\n" +

                        "Although they have an authoritative nature and it suits them perfectly, they can be stubborn sometimes and will not yield to anyone elseâ€™s opinion. According to the numerology of the alphabet, their way of approaching a problem will be in a practical way rather than emotional, and are not only dreamers but also doers.\n");
                break;
            case 'E':
                ResultOnName.setText("Results based on "+ chUpper + "\n"+
                        "People with the starting letter E in their name are outgoing and spontaneous. They love to pursue physical activities and enjoy the passion and positives in life. Since they love to live life to the fullest and do not regret anything, there are chances that they might get married more than once.\n" +

                        "Their enthusiasm for everything and their wish to fulfill every desire is contagious in a way that people around them get inspired to live the same way. Even if they are very emotional and sensible, they are equally rational and logical, and wonâ€™t be fooled easily. Unlike others, it is not difficult for them to view things from a different perspective and accept the same.");
                break;
            case 'F':
                ResultOnName.setText("Results based on "+ chUpper + "\n"+
                        "Positivity and goodness are what the people with F in their names spread wherever they go. Their way of living is quite inspiring. Always ready to help, they will never look away from someone in trouble. They are cheerful and sensible. These natives, according to name numerology, have an openness about them \n" +

                        "They are somewhat of an empath, because of which they feel and understand othersâ€™ emotions and worries. This can be a problem for them because as they feel for everyone and cannot look away from someone suffering, they will want to sacrifice their own happiness and success to make their close ones happy and satisfied.");
                break;
            case 'G':
                ResultOnName.setText("Results based on "+ chUpper + "\n" +
                        "People with the starting letter G in them are the dominating and powerful ones. Those who have the alphabet G in their name can be very intimidating as they are all business and have no bluff. They are always dedicated and hardworking and will reach their goal at any cost. Not caring what others have to say.\n" +

                        "They are usually on the right path and rarely make mistakes. But they can also be sensible and empathize. To reach their goal, they will not push someone down but will get everything they want along with lifting the other person. These people are also considered psychics as they can predict the future and can draw in fortune without effort. ");
                break;
            case 'H':
                ResultOnName.setText("Results based on "+ chUpper + "\n"+
                        "People with the starting letter H in their name are very sure of themselves and know what they are doing. They trust their intuition and feelings and opinions. Whatever they do is different from everyone else as they are creative and do not fear trying something new. Even if they have a tendency to lose money, they can earn it back just as easily. \n" +

                        "As they tend to overthink a lot, it makes them skeptical of everything, binding them from enjoying. They just need to give their mind a rest and realize that with time everything will fall into place and life has a way of making everything right in the end.");
                break;
            case 'I':
                ResultOnName.setText("Results based on "+ chUpper + "\n"+
                        "People with the starting letter I am in their names, they are in general very sensitive and care very much about the feelings of others. They try very hard not to hurt anyone or to cause problems for anyone. Born to be artists, these alphabet people have quite a grip on the field of art and can get extremely creative.\n" +

                        "But they cannot function much in dire situations and lose control, which leads to them falling prey to accidents. Maintaining a balance is very important to have stability in life. Try thinking about the consequences and planning things beforehand to avoid difficult situations.");
                break;
            case 'J':
                ResultOnName.setText("Results based on "+ chUpper +"\n" +
                        "People with the starting letter J in their name are loved by everyone as they are who they are and do not pretend to be someone else. Dependable and responsible, they will not let anyone down. They are faithful and honest, because of which they can be trusted easily. Along with everything, they are also very sensible and empathize and connect with people easily.\n" +

                        "As compassionate people, they are always ready to be of help and support to anyone in tough situations. They are also creative in nature and are quite witty and resourceful which they can use to be successful in life. Just the right amount of motivation will push them to great heights.");
                break;
            case 'K':
                ResultOnName.setText("Results based on "+ chUpper + "\n"+
                        "Success is not negotiable for those who have the alphabet K in their name. Determined to achieve everything they wish for drives them to work hard and be consistent. They have an intuitive way of thinking and will listen to everything their inner self is saying. Their brains are filled with tons of knowledge and ideas and can mold themselves to fit any situation.\n" +

                        "Being headstrong and powerful, they have all the leadership qualities which define their personality. But every good thing comes with a bad thing too. These people, although powerful and ambitious, can sometimes fall prey to self-doubt. They sometimes become unsure of their decisions and falter when taking an important step, fearing failure. \n");
                break;
            case 'L':
                ResultOnName.setText("Results based on "+ chUpper + "\n" +
                        "People with the starting letter p in their name are intelligent and do everything in an intellectual way. Making a decision is hard for them as they like to contemplate a lot. These people are genuine in nature and do everything with sincere hearts and will pretend otherwise.\n" +

                        "According to name numerology, the L name alphabet people possess all chances that they will be in accidents as they travel a lot. So they should be careful of that.");
                break;
            case 'M':
                ResultOnName.setText("Results based on "+ chUpper + "\n"+
                        "These people are very hardworking and do not like to sit around and waste time. But they should limit their working tendencies as they can overwork themselves. Since they like to have a domestic life, they work extra hard to be financially secure.\n" +

                        "Moreover, people with the alphabet M in name numerology provide their family with all the comfort. It is advised to people with this name numerology to manage their anger and solve every problem with a calm demeanor.\n");
                break;
            case 'N':
                ResultOnName.setText("Results based on "+ chUpper + "\n"+
                        "These people have a very intuitive mind and their inner self hard sends them the wrong message. Being the creative one of the lot, they will not follow the conventional ways and will come up with unique and innovative ideas.\n" +

                        "They like to gather knowledge as much as possible, and because of this they have an opinionated nature and believe in things they know. These people are also sensual, which can lead them to have many love affairs.\n");
                break;
            case 'O':
                ResultOnName.setText("Results based on "+ chUpper + "\n"+
                        "People with the starting letter O in their names are believed to be religious in nature. They have a strong moral compass and will avoid doing wrong to anyone. Their patients are commendable as they act calmly and rationally in even the most difficult situations. It is rare for them to ever break a law and always be careful with legal things.\n" +

                        "Even if they are disciplined and focused, this name numerology people sometimes get jealous about othersâ€™ success but donâ€™t let that jealousy sway their morality.\n");
                break;
            case 'P':
                ResultOnName.setText("Results based on "+ chUpper +"\n" +
                        "These people are very intelligent and resourceful. They like to read news articles and watch documentaries as they help them to gather knowledge. Even if they can become close to people easily, they avoid it as much as possible as they love their space and like to stay by themselves most of the time.\n" +

                        "They will keep their distance when necessary and can also have secrets they cannot reveal. Moreover, according to this name, numerology people have attachment issues and find it hard to let go of things.");
                break;
            case 'Q':
                ResultOnName.setText("Results based on "+ chUpper +"\n" +
                        "Fortune is high when it comes to money for those who have Q in their name. But be careful as with good fortune comes difficult situations to balance things out. Although they earn money easily, they also become victims of loss.\n" +

                        "Dominating in nature, they have an aura about them that influences othersâ€™ thoughts a lot. They do not like to open up about themselves a lot which gives them a mysterious form and usually becomes the talk of the town. They also have excellent communication skills.");
                break;
            case 'R':
                ResultOnName.setText("Results based on "+ chUpper +"\n" +
                        "People with the starting letter R in their name are empathic in nature and feel the pain of others. It is hard for them to see someone in pain and are always ready to help with everything they have.\n" +

                        "Their warm heart and inner strength are recognized by others which drives them to success. Things that can be drawbacks for them are their impatient nature and the fact that they lose their temper quite easily. Working on them will help them get all success, according to name numerology.\n");
                break;
            case 'S':
                ResultOnName.setText("Results based on "+ chUpper +"\n" +
                        "People with the starting letter S in their names are very attractive and good-looking and catch the attention of everyone wherever they go. They have kind and warm personalities which make them very desirable but they feel emotions at an extreme level, which leads them to have mood swings quite often.\n" +

                        "While making an important decision, they tend to get overwhelmed and make the decision in haste, which usually backfires on them. They should work on their endurance and try to meditate to calm their nerves\n");
                break;
            case 'T':
                ResultOnName.setText("Results based on "+ chUpper +"\n" +
                        "These people love to have adventures and are enthusiastic to try different things. They try new things all the time and use them to have various perspectives on life. They care a lot about things that are dear to them and are emotions in nature.\n" +

                        "These people tend to get hurt quite easily as they are sensitive and care what others have to say about them. These people, as per the numerology of the alphabet have a protective tendency and will not let anything hurt their loved ones. They also tend to get a bit aggressive when in a relationship." );
                break;
            case 'U':
                ResultOnName.setText("Results based on "+ chUpper +"\n" +
                        "Fortune is always with these people as they attract good luck like ants to sugar. They are simply present at the right time in the right place which gets their job done easily. Even if they have strong intuition and are creative, it is hard for them to comprehend difficult situations sometimes.\n" +

                        "People with the letter U can also get quite lazy when it comes to hard work and have commitment issues. Although they are lucky when it comes to earning money, they also are prone to wasting the same for unnecessary reasons. They can also be a little selfish in certain circumstances.");
                break;
            case 'V':
                ResultOnName.setText("Results based on "+ chUpper +"\n" +
                        "People whose name starts with V have an active intuition and can sense things before they happen. These people are highly respected in society because of their wisdom and way of living. As they have a creative way of thinking, everything they do stands out and becomes an inspiration to others. They have ideas and thoughts that will give them a lot of success and fame if they set them in motion.\n" +

                        "What makes them different from the rest is their personality which is humble and helpful. Even if they are better than others in various fields, they will not gloat about them. Although they can be the possessive type when in a relationship.");
                break;
            case 'W':
                ResultOnName.setText("Results based on "+ chUpper +"\n" +
                        "These people know their goal and will work relentlessly towards it. They will use their creative ideas to help them achieve their dreams. They do not like to idle and waste time and can also multitask when needed. Working in tough situations is not very hard for them as they are used to doing everything themselves without the help of others.\n" +

                        "Their communication skills are also very good because of which people like to be around them at all times. Meeting new people and gaining experience is something they love to do because it broadens their horizons.");
                break;
            case 'X':
                ResultOnName.setText("Results based on "+ chUpper +"\n" +
                        "People whose name starts with X are specifically passionate about nature and their creativity gives them a place wherever they go. They are very open about their choices and are ready to try everything without judgment. Their different perspectives will open new doors and opportunities in the field of careers.\n" +

                        "Quick-witted in nature, they very easily grasp new information which makes achieving success easy for them. They are also believed to be sensual beings and will indulge in carnal activities quite often.");
                break;
            case 'Y':
                ResultOnName.setText("Results based on "+ chUpper + "\n" +
                        "These people love their freedom and want to experience everything without any limitations. They like exploring new ideas and want to pave their own path. They do not appreciate it when someone tries to restrict their way of thinking as they want to learn about things without judgment.\n" +

                        "Because of this, they might indulge in questionable things which others may think twice before trying. As they are brave and self-dependent, they express themselves better than anyone and become noticeable even in a crowd. They have a very good fashion sense and carry themselves quite nicely.");
                break;
            case 'Z':
                ResultOnName.setText("Results based on "+ chUpper +"\n" +
                        "A very unique letter for a name, those who have it is the confident and energetic type. Mediocre results are not worth their attention and strive to do things with excellence. Hardworking and dedicated, they will get things done without any sweating, but they expect the same from everyone around them, which tends to disappoint them in some instances.\n" +

                        "Their intuition is strong and is always aware of their surroundings. Along with being spontaneous and enthusiastic, they also carry a loving and kind heart and are always ready to be of service. Physically, they are strong and active and can do outdoor work very easily.e been there, done that. Accordingly, 9 can effortlessly synthesize large quantities of stimuli, psychically connecting the dots to form a cohesive whole. ");
                break;


        }
    }

    public void ResultOfDay(String Day) {

        switch (Day) {
            case "MONDAY":
                ResultOnDay.setText("Results based on " +Day+"\n" +"Monday is the day of the Moon. And in astrology, Moon is rooted in a dedication to human emotions, comfort zone, maternal side, and how they express their feelings and vulnerability. It is one of the most important planets to consider when trying to use the zodiac as a tool for self-discovery. Like the moon entail the sheer power to influence tides on Earth, similarly, the Moon is said to influence the mood of the people born on Monday, making them emotional and prone to mood swings. They love being at home, fancy a feeling of shelter and consistency, and have a natural appetite for carving out their territory in the world.\n" +

                        "The emotional characteristics of the Moon can also make the people born on Monday a bit sensitive and unwelcoming towards emotional change. Such people like to be consistent with their feelings and are happiest when things are going as they have planned. People born on Monday in love are highly caring individuals and in careers are highly oriented with clear goals.");
            case "TUESDAY":
                ResultOnDay.setText("Results based on " +Day+"\n" +
                        "Tuesday is ruled by the warrior planet Mars. It is the nearest planet to Earth. The planet smears its energetic influence on people, and the people born on Tuesday thus have within themselves the uncrumpling desire to lead. Such people incline themselves toward change and are not scared to explore unfamiliar areas. However, Tuesday-born people could be materialistic. The trait, however, is not harmful until the glimmer of materialism doesnâ€™t begin to influence their decisions in life.\n" +

                        "On the downside, people born on Tuesday donâ€™t tend to think before speaking. They also have a tough time taking criticism. They get very competitive if you try to scrutinize them. This could often result in unwanted situations, especially arguments. However, the fact that Tuesday-born people entail within themselves a powerhouse of energy, they could simply undo things by arranging a special date.\n");
                break;
            case "WEDNESDAY":
                ResultOnDay.setText("Results based on " +Day+"\n" +
                        "Wednesday is ruled by the planet Mercury. It is the planet for finance travel and communication. While the trait makes them good with words, giving them the capability to talk you down into things, these people are also said to be very careless. Also, as many as three times a year, Mercury Retrograde can throw enough chaos into the lives of people born on Wednesday. However, instead of getting scared by it, their expertise in improvising helps them deal with a situation like a pro.\n" +

                        "Also, Wednesday-born people are very logical in approach and love to travel, especially with their loved ones. Talking about loved ones, people born on Wednesday in love donâ€™t tend to have a long list of demands from their partner. They are easy-going, however, could struggle at making a relationship work owing to their careless nature. Also, their tendency to keep mum when they witness emotional turmoil shrinks the possibility of emotional attachment.\n");
                break;
            case "THURSDAY":
                ResultOnDay.setText("Results based on " +Day+"\n" +
                        "In a week, Thursday is the day of Lord Vishnu and also represents the planet Jupiter. The planet Jupiter is said to be the most auspicious planet in astrology. It is said to bring growth, positivity, and optimism in an individualâ€™s life when poised positively in oneâ€™s Kundli. People born on Thursday are blessed with bigger things in life. They are good at giving advice (Like Lord Vishnu, who used to advise Gods) and are said to be one of the most mature people out there.\n" +

                        "Moreover, Thursday-born people are family-oriented. If you tend to do ten things to keep your family happy, a Thursday-born will do 20. Such is their attachment to their family; with their partner being no exception. A Thursday born in love is very passionate. However, their tendency to get bored easily might need the other person in the relationship to try to spice up things. The straightforward attitude of a Thursday born could be irritating but again, the advice they have to share is very factual and human-friendly.");
                break;
            case "FRIDAY":
                ResultOnDay.setText("Results based on " +Day+"\n" +
                        "Friday is the mushiest planet in the Zodiac because hello, it got the Venus vibes. Venus as a planet not only rules over Friday but also romance, art, beauty, pleasures, and luxuries. Simply say, Venus is in the Deepika Padukone of planets. People born on Friday are said to be a tad bit materialistic, and a bit lazy (not when it comes to sex) yet still make great lovers. A Friday born tends to attract anyone around them. And when they canâ€™t, they usually get so jealous of them that they begin competing with them. In a nutshell, they have an ego problem.\n" +

                        "People born on Friday are great at jobs that require creativity. They can brew ideas instantly and go into things with a perfectionist mindset. However, on the dark side, Friday-borns are usually dependent on others for maybe ideas and even emotional composure. They get involved in a relationship with all their heart. Simply said be it either life or romance, they cherish harmony and prefer not to ruffle any feathers.");
                break;
            case "SATURDAY":
                ResultOnDay.setText("Results based on " +Day+"\n" +
                        "The ruler of Saturday is Saturn. It is the planet of limitations. Saturn is the last planet visible in the sky to the naked eye from Earth. People born on Saturday are said to be determined and kind. They tend to be very mature and responsible for their duty. People born on Saturday are very studious, wise, and practical making them good with business. A Saturn can also get very speedy with things, which is a bummer for many in their vicinity.\n" +

                        "Moreover, people born on Saturday are also shy kind. Hence they often face difficulty to find and interacting with the opposite gender. With other humans around, they are very selective and could be crushing over a person but wonâ€™t make a move. At things that donâ€™t involve the words L-O-V-E, their confidence can outshine others. Saturday-born people are typical individualists and prefer to be alone but have great organizational skills.\n");
                break;
            case "SUNDAY":
                ResultOnDay.setText("Results based on " +Day+"\n" +

                        "Ruled by the Sun, Sunday is the first day of the week. People born on Sunday are the luckiest ducks in town not just because itâ€™s Sunday on Sunday but also because the Sun, as the King of all planets, has a great influence on such people. The Sun allows these people an aura and magnetic power like its own. This helps them connect well with their surroundings. For the unaware, the Sun visits the same spot that it occupied at the moment of your birth in one-year intervals. This is a sign of consistency. And consistency helps a person enhance the quality of leadership. Talking about leadership, these people, are free-spirited, like contributing their ideas instead of just nodding to what their senior says.\n" +

                        "Despite being introverted, Sunday-born people are fun to be around. However, they sometimes can be very self-centered, doubting, authoritative, and insecure too. Also, they donâ€™t like to be ignored. And if you do ignore them, they would not mind cutting you off from their life doesnâ€™t matter how much you matter to them. For them, self-respect is the highest form of respect. ");
                break;

        }
    }
    public static int sumOfDigits(int number) {
        int sum = 0;
        //used while loop
        while (number > 0) {
            //Check the last digit of the number and add that digit to the sum variable
            sum += number % 10;
            //Omit the last digit of the number
            number /= 10;
        }

        return sum;
    }

}