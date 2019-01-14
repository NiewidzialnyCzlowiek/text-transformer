**REST API doc**
----
  Text-Transformer API call

* **URL**

  `/transform`

* **Method:**

  `POST`

* **Data Params**
  
   **Required:**
 
   `text=[string]` 
   
   text to transform

   **Optional:**
          
   `repetition_del=[boolean]`
   
   delete repeating words
 
   `num_to_text=[boolean]`
   
   apply number-to-text
    
   `expand=[boolean]`
   
   perform abbreviation expansion
       
   `shrink=[boolean]`
   
   use abbreviations where possible
       
   `latex=[boolean]`
   
   latex format special characters
       
   `transformations=[["upper" | "lower" | "capitalize" | "inverse" | "pokemonize" | "toCode" | "wordReverse"]]`
   
   array representing chain of transformations to be peformed on text after preprocessing

* **Success Response:**
  * **Code:** 200 OK <br />
    **Content:** 
    ```javascript
    { 
      text : "To jest wynik działania programu.",
      time_nanos: "12345"
    }
    ```
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
    **Content:** `{ error : "Parameter text not specified" }`

  OR
  
  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Unknown transformation type" }`

  OR

  * TODO
  
  
* **Sample Call:**

  ```javascript
    var req = {
      text: "to jest testowe zapytanie które ma na przykład taki skrót i % symbol",
      shrink: "true",
      latex: "true",
      transformations: ["capitalize", "inverse"]
    }
    $.ajax({
      url: "/transform"
      dataType: "json",
      data: req,
      type : "POST"
      success : function(r) {
        console.log(r);
      }
    });
  ```
  
  expected result:
  
  **Code:** 200 OK <br />
  **Content:** `{ text : "lobmyS \% I tórkS ikaT .pN aM erótK einatypaZ ewotseT tseJ oT" }`
  
  
* **Notes:**
   * preprocessing consists of: repetition_del, num_to_text, expand, shrink (in listed order)
   * same transformation can be used more than once
   * transformations listed in transformations param are performed after preprocessing
   * transformations are applied in order that they appear in the array (transformations param)
   * latex is performed after transformations
