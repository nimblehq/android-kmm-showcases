//
//  JobDetailsViewModel.swift
//  iosApp
//
//  Created by Edgars Simanovskis on 25/3/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import Foundation
import shared

class JobDetailsViewModel: ObservableObject {
    @Published var jobDetails: JobDetail? = nil
    
    func getDetails() {
        RepositoryImpl().getJobDetail { details, error in
            self.jobDetails = details
        }
    }
}
