import java.text.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.lang.Math.*;

class Meditation {
  static int seconds = 0;
  static String startTime = "";
  static String endTime = "";

  public static void meditate() {
    seconds += getDuration(startTime, endTime);
  }

  public String getTotal() {
    // convert seconds to seconds and minutes
    String str = "";

    // if the seconds is less than 10, then add an aditional 0 so that it looks like
    // 10:09 rather than 10:9
    if ((seconds % 60) < 10) {
      str = (seconds - (seconds % 60)) / 60 + ":0" + seconds % 60 + " minutes";
    } else {
      str = (seconds - (seconds % 60)) / 60 + ":" + seconds % 60 + " minutes";
    }

    return str;
  }

  // get time function
  public static String getTime() {
    // this is the format of time, makes it more legible when debugging
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    // return the time when this is called
    LocalDateTime now = LocalDateTime.now();

    // convert it to the format
    String time = dtf.format(now);

    // return the time
    return time;
  }

  public static int getDuration(String start, String end) {
    // these attributes are assigned values when the buttons for starting and
    // stopping are pressed
    String dateStart = start;
    String dateStop = end;

    // Custom date format
    SimpleDateFormat time = new SimpleDateFormat("yy/MM/dd HH:mm:ss");

    // defaulting the dates to nothing
    Date d1 = null;
    Date d2 = null;

    // parsing the dates to time.
    try {
      d1 = time.parse(dateStart);
      d2 = time.parse(dateStop);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    // Get sec from each, and subtract.
    double diff = d2.getTime() - d1.getTime();
    double diffSeconds = diff / 1000;
    System.out.println("Time in seconds: " + diffSeconds + " seconds.");

    return (int) diffSeconds;
  }

  // This generates a quote from a list of about 70.
  public static String quote() {
    String quote = "";

    String[] quotes = { "Life is about making an impact, not making an income. --Kevin Kruse",
        "Whatever the mind of man can conceive and believe, it can achieve. –Napoleon Hill",
        "Strive not to be a success, but rather to be of value. –Albert Einstein",
        "You miss 100% of the shots you don’t take. –Wayne Gretzky",
        "Every strike brings me closer to the next home run. –Babe Ruth",
        "Definiteness of purpose is the starting point of all achievement. –W. Clement Stone",
        "Life isn't about getting and having, it's about giving and being. –Kevin Kruse",
        "Life is what happens to you while you’re busy making other plans. –John Lennon",
        "We become what we think about. –Earl Nightingale", "Explore, Dream, Discover. –Mark Twain",
        "Life is 10% what happens to me and 90% of how I react to it. –Charles Swindoll",
        " The mind is everything. What you think you become. –Buddha",
        " Your time is limited, so don’t waste it living someone else’s life. –Steve Jobs",
        " Winning isn’t everything, but wanting to win is. –Vince Lombardi",
        " Either you run the day, or the day runs you. –Jim Rohn",
        " Whether you think you can or you think you can’t, you’re right. –Henry Ford",
        " The best revenge is massive success. –Frank Sinatra",
        " Life shrinks or expands in proportion to one's courage. –Anais Nin",
        " Believe you can and you’re halfway there. –Theodore Roosevelt",
        " Everything you’ve ever wanted is on the other side of fear. –George Addair",
        " Teach thy tongue to say, I do not know, and thous shalt progress. –Maimonides",
        " Start where you are. Use what you have. Do what you can. –Arthur Ashe",
        " Fall seven times and stand up eight. –Japanese Proverb",
        " When one door of happiness closes, another opens –Helen Keller",
        " Everything has beauty, but not everyone can see. –Confucius",
        " When I let go of what I am, I become what I might be. –Lao Tzu",
        " Happiness is not something readymade. It comes from your own actions. –Dalai Lama",
        " If the wind will not serve, take to the oars. –Latin Proverb", "When we fall, we get hurt - Brandon",
        "Where you are is different from who you are - Logan",
        " If you want to lift yourself up, lift up someone else. –Booker T. Washington",
        " I didn’t fail the test. I just found 100 ways to do it wrong. –Benjamin Franklin",
        " A person who never made a mistake never tried anything new. – Albert Einstein",
        " There are no traffic jams along the extra mile. –Roger Staubach",
        " It is never too late to be what you might have been. –George Eliot",
        " You become what you believe. –Oprah Winfrey",
        " I would rather die of passion than of boredom. –Vincent van Gogh",
        " Build your own dreams, or someone else will hire you to build theirs. –Farrah Gray",
        " Education costs money. But then so does ignorance. –Sir Claus Moser",
        " It does not matter how slowly you go as long as you do not stop. –Confucius",
        " You can’t use up creativity. The more you use, the more you have. –Maya Angelou",
        " Dream big and dare to fail. –Norman Vaughan",
        " Do what you can, where you are, with what you have. –Teddy Roosevelt",
        " Dreaming, after all, is a form of planning. –Gloria Steinem",
        " Remember no one can make you feel inferior without your consent. –Eleanor Roosevelt",
        " Life is what we make it, always has been, always will be. –Grandma Moses",
        " The question isn’t who is going to let me; it’s who is going to stop me. –Ayn Rand",
        " Change your thoughts and you change your world. –Norman Vincent Peale",
        "Nothing is impossible, the word itself says, “I’m possible!” –Audrey Hepburn",
        "The only way to do great work is to love what you do. –Steve Jobs",
        "If you can dream it, you can achieve it. –Zig Ziglar" };

    int rand = (int) (Math.random() * quotes.length);
    quote = quotes[rand];
    System.out.println(quote);
    return quote;
  }
}
