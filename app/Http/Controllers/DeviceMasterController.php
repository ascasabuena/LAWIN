<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;


use App\DeviceMaster;


class DeviceMasterController extends Controller
{
    public function setDeviceMaster(Request $request){
    	$phoneNo = $request->input('phoneNo');
    	$dateManufactured = $request->input('dateManufactured');
    	$serialNo = $request->input('serialNo');
    	$dateUpdated = $request->input('dateUpdated');
    	
    	$device_master = DeviceMaster::where('serial_no', $serialNo)
    	              ->where('phone_no',$phoneNo)
    	              ->first();
    	//if device not exist, register it.
    	if(!$device_master){	
	    	$devices = DeviceMaster::create ([
	    		'phone_no' => $phoneNo,
		    	'date_manufactured' => $dateManufactured, 
		    	'serial_no' => $serialNo
	    	]);
			
	    	return response()->json($devices);
		} else {
			return response()->json([
				'message' => 'Error device already registered.'
			]);
    	}

    }
}
