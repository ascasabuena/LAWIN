<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Devices;
use App\Reports;
use App\Users;

class DevicesController extends Controller
{
    public function setDevice(Request $request){
    	$phoneNo = $request->input('phoneNo');
    	$type = $request->input('type');
    	$date_updated = $request->input('date_updated');
    	$date_created = $request->input('date_created');

    	//checks if a user exists based on username or email
    	$users = Users::where('username', $username)->orwhere('email',$email)->first();

    }
}
