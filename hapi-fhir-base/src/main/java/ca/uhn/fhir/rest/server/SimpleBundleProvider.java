package ca.uhn.fhir.rest.server;

/*
 * #%L
 * HAPI FHIR Library
 * %%
 * Copyright (C) 2014 University Health Network
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.Collections;
import java.util.List;

import ca.uhn.fhir.model.api.IResource;
import ca.uhn.fhir.model.primitive.InstantDt;

public class SimpleBundleProvider implements IBundleProvider {

	private List<IResource> myList;
	
	public SimpleBundleProvider(List<IResource> theList) {
		myList = theList;
	}

	public SimpleBundleProvider(IResource theResource) {
		myList = Collections.singletonList(theResource);
	}

	/**
	 * Create an empty bundle
	 */
	public SimpleBundleProvider() {
		myList = Collections.emptyList();
	}

	@Override
	public List<IResource> getResources(int theFromIndex, int theToIndex) {
		return myList.subList(theFromIndex, Math.min(theToIndex, myList.size()));
	}

	@Override
	public int size() {
		return myList.size();
	}

	@Override
	public InstantDt getPublished() {
		return InstantDt.withCurrentTime();
	}
	
}
