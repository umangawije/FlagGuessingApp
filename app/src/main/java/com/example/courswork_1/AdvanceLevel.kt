package com.example.courswork_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courswork_1.ui.theme.Courswork_1Theme

class AdvanceLevel : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdvanceLevelDisplay()
        }
    }
}


@Composable
fun AdvanceLevelDisplay() {
    MaterialTheme {
        val jsonString = """
            {"AD": "Andorra",
            "AE": "United Arab Emirates",
            "AF": "Afghanistan",
            "AG": "Antigua and Barbuda",
            "AI": "Anguilla",
            "AL": "Albania",
            "AM": "Armenia",
            "AO": "Angola",
            "AQ": "Antarctica",
            "AR": "Argentina",
            "AS": "American Samoa",
            "AT": "Austria",
            "AU": "Australia",
            "AW": "Aruba",
            "AX": "\u00c5land Islands",
            "AZ": "Azerbaijan",
            "BA": "Bosnia and Herzegovina",
            "BB": "Barbados",
            "BD": "Bangladesh",
            "BE": "Belgium",
            "BF": "Burkina Faso",
            "BG": "Bulgaria",
            "BH": "Bahrain",
            "BI": "Burundi",
            "BJ": "Benin",
            "BL": "Saint Barthélemy",
            "BM": "Bermuda",
            "BN": "Brunei Darussalam",
            "BO": "Bolivia, Plurinational State of",
            "BQ": "Caribbean Netherlands",
            "BR": "Brazil",
            "BS": "Bahamas",
            "BT": "Bhutan",
            "BV": "Bouvet Island",
            "BW": "Botswana",
            "BY": "Belarus",
            "BZ": "Belize",
            "CA": "Canada",
            "CC": "Cocos (Keeling) Islands",
            "CD": "Congo, the Democratic Republic of the",
            "CF": "Central African Republic",
            "CG": "Republic of the Congo",
            "CH": "Switzerland",
            "CI": "C\u00f4te d'Ivoire",
            "CK": "Cook Islands",
            "CL": "Chile",
            "CM": "Cameroon",
            "CN": "China (People's Republic of China)",
            "CO": "Colombia",
            "CR": "Costa Rica",
            "CU": "Cuba",
            "CV": "Cape Verde",
            "CW": "Cura\u00e7ao",
            "CX": "Christmas Island",
            "CY": "Cyprus",
            "CZ": "Czech Republic",
            "DE": "Germany",
            "DJ": "Djibouti",
            "DK": "Denmark",
            "DM": "Dominica",
            "DO": "Dominican Republic",
            "DZ": "Algeria",
            "EC": "Ecuador",
            "EE": "Estonia",
            "EG": "Egypt",
            "EH": "Western Sahara",
            "ER": "Eritrea",
            "ES": "Spain",
            "ET": "Ethiopia",
            "EU": "Europe",
            "FI": "Finland",
            "FJ": "Fiji",
            "FK": "Falkland Islands (Malvinas)",
            "FM": "Micronesia, Federated States of",
            "FO": "Faroe Islands",
            "FR": "France",
            "GA": "Gabon",
            "GB-ENG": "England",
            "GB-NIR": "Northern Ireland",
            "GB-SCT": "Scotland",
            "GB-WLS": "Wales",
            "GB": "United Kingdom",
            "GD": "Grenada",
            "GE": "Georgia",
            "GF": "French Guiana",
            "GG": "Guernsey",
            "GH": "Ghana",
            "GI": "Gibraltar",
            "GL": "Greenland",
            "GM": "Gambia",
            "GN": "Guinea",
            "GP": "Guadeloupe",
            "GQ": "Equatorial Guinea",
            "GR": "Greece",
            "GS": "South Georgia and the South Sandwich Islands",
            "GT": "Guatemala",
            "GU": "Guam",
            "GW": "Guinea-Bissau",
            "GY": "Guyana",
            "HK": "Hong Kong",
            "HM": "Heard Island and McDonald Islands",
            "HN": "Honduras",
            "HR": "Croatia",
            "HT": "Haiti",
            "HU": "Hungary",
            "ID": "Indonesia",
            "IE": "Ireland",
            "IL": "Israel",
            "IM": "Isle of Man",
            "IN": "India",
            "IO": "British Indian Ocean Territory",
            "IQ": "Iraq",
            "IR": "Iran, Islamic Republic of",
            "IS": "Iceland",
            "IT": "Italy",
            "JE": "Jersey",
            "JM": "Jamaica",
            "JO": "Jordan",
            "JP": "Japan",
            "KE": "Kenya",
            "KG": "Kyrgyzstan",
            "KH": "Cambodia",
            "KI": "Kiribati",
            "KM": "Comoros",
            "KN": "Saint Kitts and Nevis",
            "KP": "Korea, Democratic People's Republic of",
            "KR": "Korea, Republic of",
            "KW": "Kuwait",
            "KY": "Cayman Islands",
            "KZ": "Kazakhstan",
            "LA": "Laos (Lao People's Democratic Republic)",
            "LB": "Lebanon",
            "LC": "Saint Lucia",
            "LI": "Liechtenstein",
            "LK": "Sri Lanka",
            "LR": "Liberia",
            "LS": "Lesotho",
            "LT": "Lithuania",
            "LU": "Luxembourg",
            "LV": "Latvia",
            "LY": "Libya",
            "MA": "Morocco",
            "MC": "Monaco",
            "MD": "Moldova, Republic of",
            "ME": "Montenegro",
            "MF": "Saint Martin",
            "MG": "Madagascar",
            "MH": "Marshall Islands",
            "MK": "North Macedonia",
            "ML": "Mali",
            "MM": "Myanmar",
            "MN": "Mongolia",
            "MO": "Macao",
            "MP": "Northern Mariana Islands",
            "MQ": "Martinique",
            "MR": "Mauritania",
            "MS": "Montserrat",
            "MT": "Malta",
            "MU": "Mauritius",
            "MV": "Maldives",
            "MW": "Malawi",
            "MX": "Mexico",
            "MY": "Malaysia",
            "MZ": "Mozambique",
            "NA": "Namibia",
            "NC": "New Caledonia",
            "NE": "Niger",
            "NF": "Norfolk Island",
            "NG": "Nigeria",
            "NI": "Nicaragua",
            "NL": "Netherlands",
            "NO": "Norway",
            "NP": "Nepal",
            "NR": "Nauru",
            "NU": "Niue",
            "NZ": "New Zealand",
            "OM": "Oman",
            "PA": "Panama",
            "PE": "Peru",
            "PF": "French Polynesia",
            "PG": "Papua New Guinea",
            "PH": "Philippines",
            "PK": "Pakistan",
            "PL": "Poland",
            "PM": "Saint Pierre and Miquelon",
            "PN": "Pitcairn",
            "PR": "Puerto Rico",
            "PS": "Palestine",
            "PT": "Portugal",
            "PW": "Palau",
            "PY": "Paraguay",
            "QA": "Qatar",
            "RE": "Réunion",
            "RO": "Romania",
            "RS": "Serbia",
            "RU": "Russian Federation",
            "RW": "Rwanda",
            "SA": "Saudi Arabia",
            "SB": "Solomon Islands",
            "SC": "Seychelles",
            "SD": "Sudan",
            "SE": "Sweden",
            "SG": "Singapore",
            "SH": "Saint Helena, Ascension and Tristan da Cunha",
            "SI": "Slovenia",
            "SJ": "Svalbard and Jan Mayen Islands",
            "SK": "Slovakia",
            "SL": "Sierra Leone",
            "SM": "San Marino",
            "SN": "Senegal",
            "SO": "Somalia",
            "SR": "Suriname",
            "SS": "South Sudan",
            "ST": "Sao Tome and Principe",
            "SV": "El Salvador",
            "SX": "Sint Maarten (Dutch part)",
            "SY": "Syrian Arab Republic",
            "SZ": "Swaziland",
            "TC": "Turks and Caicos Islands",
            "TD": "Chad",
            "TF": "French Southern Territories",
            "TG": "Togo",
            "TH": "Thailand",
            "TJ": "Tajikistan",
            "TK": "Tokelau",
            "TL": "Timor-Leste",
            "TM": "Turkmenistan",
            "TN": "Tunisia",
            "TO": "Tonga",
            "TR": "Turkey",
            "TT": "Trinidad and Tobago",
            "TV": "Tuvalu",
            "TW": "Taiwan (Republic of China)",
            "TZ": "Tanzania, United Republic of",
            "UA": "Ukraine",
            "UG": "Uganda",
            "UM": "US Minor Outlying Islands",
            "US": "United States",
            "UY": "Uruguay",
            "UZ": "Uzbekistan",
            "VA": "Holy See (Vatican City State)",
            "VC": "Saint Vincent and the Grenadines",
            "VE": "Venezuela, Bolivarian Republic of",
            "VG": "Virgin Islands, British",
            "VI": "Virgin Islands, U.S.",
            "VN": "Vietnam",
            "VU": "Vanuatu",
            "WF": "Wallis and Futuna Islands",
            "WS": "Samoa",
            "XK": "Kosovo",
            "YE": "Yemen",
            "YT": "Mayotte",
            "ZA": "South Africa",
            "ZM": "Zambia",
            "ZW": "Zimbabwe"
            }
        """.trimIndent()  //Country list

        //variables to manage states
        val countries = remember { loadCountriesFromJson(jsonString) }
        var randomCountry1 by remember { mutableStateOf(countries.random()) } // Get first random country from list }
        var randomCountry2 by remember { mutableStateOf(countries.random()) } // Get second random country from list }
        var randomCountry3 by remember { mutableStateOf(countries.random()) } // Get third random country from list }


        var selectedCountryNameList = remember { mutableListOf(randomCountry1.name, randomCountry2.name, randomCountry3.name)}

        var country1Name by remember { mutableStateOf("") }
        var country2Name by remember { mutableStateOf("") }
        var country3Name by remember { mutableStateOf("") }

        var isCorrect1 by remember { mutableStateOf(true) }
        var isCorrect2 by remember { mutableStateOf(true) }
        var isCorrect3 by remember { mutableStateOf(true) }

        var textFieldColor by remember { mutableStateOf(Color.Black) }
        var buttonLable by remember { mutableStateOf("Submit") }
        var resultMessage by remember{ mutableStateOf("") }
        var submitCount by remember { mutableStateOf(0) }
        var incorrectAttemptsThisTime by remember{ mutableStateOf(0) }

        var userScore by remember { mutableStateOf(0) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ) {

            //Display the score
            Text(
                text = "Score: $userScore/3",
                color = Color.Black,
                modifier = Modifier
                    .padding( end = 16.dp)
                    .align(Alignment.End)
            )

            //Display random country image 1
            Image(
                painter = painterResource(id = getResourceId(randomCountry1.code)),
                contentDescription = "flag image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))  //put space between

            //Textfield to enter first country name
            TextField(
                value = country1Name,
                onValueChange = {country1Name = it},
                enabled = isCorrect1,
                modifier = Modifier.align(Alignment.CenterHorizontally)

            )

            Spacer(modifier = Modifier.height(20.dp))  //put space between

            //Display random country image 2
            Image(
                painter = painterResource(id = getResourceId(randomCountry2.code)),
                contentDescription = "flag image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))  //put space between

            //Textfield to enter second country name
            TextField(
                value = country2Name,
                onValueChange = {country2Name = it},
                enabled = isCorrect2,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))  //put space between

            //Display random country image 3
            Image(
                painter = painterResource(id = getResourceId(randomCountry3.code)),
                contentDescription = "flag image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))  //put space between

            //Textfield to enter third country name
            TextField(
                value = country3Name,
                onValueChange = {country3Name = it},
                enabled = isCorrect3,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(textFieldColor)
            )
            Spacer(modifier = Modifier.height(20.dp))  //put space between

            if (buttonLable == "Submit") {
                Button(
                    onClick = {
                        submitCount++

                        //Check entered country names are correct or incorrect
                        if (randomCountry1.name.lowercase() != country1Name.lowercase()) {
                            isCorrect1 = true  //keep the text field enabled
                            incorrectAttemptsThisTime++ //increase incorrect attempts by 1
                        }else{
                            if(randomCountry1.name.lowercase() == country1Name.lowercase()) {
                                isCorrect1 = false //greyed out the text field (disable the textfield)
                                userScore ++
                            }
                        }

                        if (randomCountry2.name.lowercase() != country2Name.lowercase()) {
                            isCorrect2 = true
                            incorrectAttemptsThisTime++
                        }else{
                            if (randomCountry2.name.lowercase() == country2Name.lowercase()) {
                                isCorrect2 = false
                                userScore++
                            }
                        }

                        if (randomCountry3.name.lowercase() != country3Name.lowercase()) {
                            isCorrect3 = true
                            incorrectAttemptsThisTime++
                        }else {
                            if (randomCountry3.name.lowercase() == country3Name.lowercase()) {
                                isCorrect3 = false
                                userScore++
                            }
                        }
                        if(incorrectAttemptsThisTime >= 3){  //if incorrect attempts is 3 or more
                            resultMessage = "Wrong"  //result message to wrong
                            buttonLable = "Next"     //change the button lable to next
                        }else{
                            resultMessage = "Correct"
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally) //Button align to the center
                ) {
                    Text(text = buttonLable)
                }
            }else{  //for next button
                Button(onClick = {
                    randomCountry1 = countries.random()  //select a random country
                    randomCountry2 = countries.random()
                    randomCountry3 = countries.random()

                    //Reset all the state values
                    country1Name = ""
                    country2Name = ""
                    country3Name = ""

                    isCorrect1 = true
                    isCorrect2 = true
                    isCorrect3 = true

                    resultMessage = ""
                    incorrectAttemptsThisTime = 0

                    buttonLable = "Submit"   //reset button to submit
                },
                    modifier = Modifier.align(Alignment.CenterHorizontally) //Button align to the center
                ){

                    Text(text = buttonLable)  //button named as "Submit"
                }
            }
            //Text(text = "name${selectedCountryNameList}")  //delete this
            //Text(text = "count ${incorrectAttemptsThisTime}") //
            //Text(text = resultMessage)
            if(resultMessage == "Wrong") { //Display wrong massage in red
                Text(
                    text = resultMessage,
                    color = Color.Red
                )
                //Display country names in blue with the wrong message
                Text(
                    text = "Correct Name : ${randomCountry1.name},${randomCountry2.name}, ${randomCountry3.name}",
                    color = Color.Blue)
            }
            if(resultMessage == "Correct"){   //Display correct massage in green
                Text(
                    text = resultMessage,
                    color = Color.Green
                )

            }
        }

    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AdvanceLevelDisplay()
}