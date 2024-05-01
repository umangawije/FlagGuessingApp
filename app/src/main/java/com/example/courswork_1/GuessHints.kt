package com.example.courswork_1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import org.json.JSONObject


class GuessHints : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessCountryForHint()
        }
    }
}


@Composable
fun GuessCountryForHint() {
    MaterialTheme{
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
        """.trimIndent()  //country name and code list

        //variables to manage state
        val countries = remember { loadCountriesFromJson(jsonString) }
        var randomCountry by remember { mutableStateOf(countries.random()) } // Pick random country from list }

        var isAnswerCorrect by remember { mutableStateOf(false) }
        var isSubmitClicked by remember{ mutableStateOf(false) }

        var incorrectGuess by remember { mutableStateOf(0) }
        var resultMessage by remember { mutableStateOf("") }
        var buttonLable by remember { mutableStateOf("Submit") }


        var inputText by remember { mutableStateOf("") }
        var dashedCountryName by remember {
            mutableStateOf(
                buildAnnotatedString { //build a string where random country name displayed as dashed
                    repeat(randomCountry.name.length){
                        append("-")
                    }
                }
            )
        }


        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ){
            Text(
                text = "Guess The Country",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 10.dp)
            )

            //Display the Country image
            Image(
                painter = painterResource(id = getResourceId(randomCountry.code)),
                contentDescription = "flag image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)

            )

            Spacer(modifier = Modifier.height(20.dp))

            //Display dashed
            Text(
                text = dashedCountryName,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            //Textfiel to input country name
            TextField(
                value = inputText,
                onValueChange = {inputText = it},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            //Submit Button
            if (buttonLable == "Submit") { //if button label is submit then user will allow to submit the answer and see the result
                Button(
                    onClick = {
                        if (inputText.length == 1) {
                            val char = inputText.first().toLowerCase()
                            val countryNameLower = randomCountry.name.toLowerCase()
                            val builder = buildAnnotatedString {
                                var allGuessed = true
                                for (i in randomCountry.name.indices) {
                                    if (countryNameLower[i] == char || dashedCountryName[i] != '-') {
                                        append(randomCountry.name[i])

                                    } else {
                                        append("-")
                                        allGuessed = false
                                    }
                                }
                                if (!allGuessed && countryNameLower.contains(char).not()) {
                                    incorrectGuess++
                                    if (incorrectGuess >= 3) {
                                        resultMessage = "WRONG!/" //${randomCountry.name}"
                                        buttonLable = "Next"


                                    }
                                }
                                if (allGuessed) {
                                    resultMessage = "CORRECT"
                                    buttonLable = "Next"

                                }
                            }
                            dashedCountryName = builder
                            inputText = ""
                        }

                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally) //Button align to the center
                ) {
                    Text(text = buttonLable) //Change the button lable to Next

                }
            }else{ // when button change to "Next"
                Button(
                    onClick = { //Clicking on the next button will reset the data and provide user a new game
                        randomCountry = countries.random()  //select a random country
                        dashedCountryName = buildAnnotatedString {
                            repeat(randomCountry.name.length){
                                append("-")
                            }
                        }
                        isAnswerCorrect = false  //reset values
                        isSubmitClicked = false
                        incorrectGuess = 0
                        resultMessage = ""
                        buttonLable = "Submit"
                        inputText = ""

                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally) //Button align to the center
                ) {
                    Text(text = buttonLable)  //button named as "Submit"

                }
            }

            if (resultMessage == "WRONG!/") {  //if the answer is incorrect wrong massage display with country name
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Red)) { //display wrong massage in red colour
                            append(resultMessage)
                        }
                        withStyle(style = SpanStyle(color = Color.Blue)) { //display country name in blue colour
                            append(randomCountry.name)
                        }
                    }
                )
            }else{  // if the answer is correct display correct massage
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Green)) { //diplay correct massage in Green
                            append(resultMessage)
                        }
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    GuessCountryForHint()
}