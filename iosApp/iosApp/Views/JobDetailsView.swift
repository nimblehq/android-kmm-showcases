//
//  JobDetailsView.swift
//  iosApp
//
//  Created by Edgars Simanovskis on 22/3/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import SwiftUI

struct JobDetailsView: View {
    var navTitle = "Job Detail"
    
    var body: some View {
        VStack() {
            NavBar(title: navTitle)
            JobInfoView()
            AcceptView()
        }
        .background(Color.offWhite.ignoresSafeArea())
        .ignoresSafeArea()
        .navigationBarHidden(true)
        
    }
}



struct JobDetailsView_Previews: PreviewProvider {
    static var previews: some View {
        JobDetailsView()
    }
}
