<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use PHPMailer\PHPMailer;
use App\Devices;
use App\Reports;
use App\Users;

class DevicesController extends Controller
{
    public function setDevice(Request $request){
    	$phoneNo = $request->input('phoneNo');
    	$type = $request->input('type');
    	$userID = $request->input('userID');
    	
    	$users_devices = Devices::where('users_id', $userID)
    	              ->where('phone_no',$phoneNo)
    	              ->first();
    	//if user not exist, register it.
    	if(!$users_devices){	
	    	$devices = Devices::create ([
	    		'phone_no' => $phoneNo,
		    	'type' => $type, //drop down button (receiver,transmitter)
		    	'users_id' => $userID,
	    	]);

			$mail = new PHPMailer\PHPMailer(true);

			try {
			    //Server settings
			    $mail->SMTPDebug = 0;                      // Enable verbose debug output
			    $mail->isSMTP();                                            // Send using SMTP
			    $mail->Host       = 'smtp.gmail.com';                    // Set the SMTP server to send through
			    $mail->SMTPAuth   = true;                                   // Enable SMTP authentication
			    $mail->Username   = 'lawin.apc@gmail.com';                     // SMTP username
			    $mail->Password   = 'be@rammm';                               // SMTP password
			    $mail->SMTPSecure = 'ssl';         // Enable TLS encryption; `PHPMailer::ENCRYPTION_SMTPS` also accepted
			    $mail->Port       = 465;                                    // TCP port to connect to

			    //Recipients
			    $mail->setFrom('lawin.apc@gmail.com', 'LAWIN No-Reply');
			    //$mail->addAddress($email,$fname.' '.$lname);     // Add a recipient
			   
			    // Content
			    $mail->isHTML(true);                                  // Set email format to HTML
			    $mail->Subject = 'Lawin registration';
			    $mail->Body    = 'Please confirm your email....';

			    //$mail->send();
			    
			} catch (Exception $e) {
			    return response()->json([
			    	'message' => $mail->ErrorInfo
			    ]);
			}

	    	return response()->json($devices);
		} else {
			return response()->json([
				'message' => 'Error phone number already exists to this account.'
			]);
    	}

    }
}
